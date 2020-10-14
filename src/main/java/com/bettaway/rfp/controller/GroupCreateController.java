package com.bettaway.rfp.controller;

import com.bettaway.rfp.modal.Group;
import com.bettaway.rfp.request.RequestBuilder;
import com.bettaway.rfp.response.ResponseBean;
import com.bettaway.rfp.service.GroupService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/group/")
@CrossOrigin(origins = "*", maxAge = 36000)
public class GroupCreateController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private RequestBuilder requestBuilder;

   /* @Autowired
    SellerProfileService sellerProfileService;
*/
  /*  @Autowired
    BuyerProfileService buyerProfileService;*/


    @GetMapping("list")
    public ResponseEntity<ResponseBean> getListOfGroups(@RequestHeader("authId") String authId) {
        if (authId == null) {
            return ResponseEntity.ok(ResponseBean.failure("User is unauthorised"));
        }
        ResponseEntity<ResponseBean> group = groupService.findByAuthId(authId);
        return group;
    }


    @PostMapping("create")
    public ResponseEntity<ResponseBean> createGroup(@RequestBody String request, @RequestHeader("authId") String authId) {
        JSONObject jsonObject = (JSONObject) JSONValue.parse(request);
        String groupName = (String) jsonObject.get("groupName");
        if (authId == null) {
            return ResponseEntity.ok(ResponseBean.failure("User is unauthorised"));
        }
        if (groupName == null) {
            return ResponseEntity.ok(ResponseBean.failure("group name can not be null"));
        }
        if (groupName.trim().length() == 0) {
            return ResponseEntity.ok(ResponseBean.failure("group name can not be empty"));
        }
        JSONArray sellerObject = (JSONArray) jsonObject.get("seller");
        Group group = new Group();
        group.setGroupName(groupName);
        List<String> sellers = new ArrayList<String>();
        if (sellerObject.isEmpty()) {
            return ResponseEntity.ok(ResponseBean.failure("seller object not exist"));
        } else {
            Iterator itr2 = sellerObject.iterator();
            while (itr2.hasNext()) {
                Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
                while (itr1.hasNext()) {
                    Map.Entry pair = itr1.next();
                    if (pair.getKey().equals("sellerId")) {
                        JSONObject requestBody = new JSONObject();
                        requestBody.put("userId", pair.getValue().toString());
                        String userServiceUrl = "http://USER-SERVICE/user/seller/user-info";
                        ResponseEntity<String> response = requestBuilder.call(userServiceUrl, requestBody.toJSONString());
                        JSONObject _response = (JSONObject) JSONValue.parse(response.getBody());
                        String status = (String) _response.get("status");
                        if (status.equalsIgnoreCase("FAILURE")) {
                            return ResponseEntity.ok(ResponseBean.failure("seller object not exist : " + pair.getValue().toString()));
                        } else {
                            JSONObject payload = (JSONObject) _response.get("payload");
                            String payloadUserId = (String) payload.get("userId");
                            sellers.add(payloadUserId);
                        }
                    }
                }
            }
        }
        Set<String> duplicateInStream = findDuplicateInSellerId(sellers);
        if (duplicateInStream.size() > 0) {
            return ResponseEntity.ok(ResponseBean.failure("sellerId can not be duplicate " + duplicateInStream));
        }
        System.out.println(duplicateInStream);
        if (sellers.size() == 0) {
            return ResponseEntity.ok(ResponseBean.failure("sellerId not exist in seller object"));
        }
        //buyer-info-auth

        JSONObject buyerRequestBody = new JSONObject();
        buyerRequestBody.put("authId", authId);
        String buyerUserServiceUrl = "http://USER-SERVICE/user/buyer/buyer-info-auth";
        ResponseEntity<String> buyerResponse = requestBuilder.call(buyerUserServiceUrl, buyerRequestBody.toJSONString());
        JSONObject _responseBuyer = (JSONObject) JSONValue.parse(buyerResponse.getBody());
        String statusBuyer = (String) _responseBuyer.get("status");
        if (statusBuyer.equalsIgnoreCase("FAILURE")) {
            return ResponseEntity.ok(ResponseBean.failure("User is unauthorised"));
        } else {
            JSONObject payloadBuyer = (JSONObject) _responseBuyer.get("payload");
            String payloadUserId = (String) payloadBuyer.get("userId");
            sellers.add(payloadUserId);
        }
       /* BuyerProfile buyerProfile = buyerProfileService.findByAuthId(Long.valueOf(authId));
        if (buyerProfile == null) {
            return ResponseEntity.ok(ResponseBean.failure("User is unauthorised"));
        }*/
        group.setSellerProfileId(sellers);
        group.setAuthId(authId);
        // group.setBuyerId(buyerProfile.getUserId());
        group = groupService.save(group);
        return ResponseEntity.ok(ResponseBean.success(group, "Group added successfully."));
    }

    public static <T> Set<T> findDuplicateInSellerId(List<T> list) {
        // Return the set of duplicate elements
        return

                // Get the stream from the list
                list.stream()

                        // Count the frequency of each element
                        // and filter the elements
                        // with frequency > 1
                        .filter(i -> Collections.frequency(list, i) > 1)

                        // And Collect them in a Set
                        .collect(Collectors.toSet());
    }
}
