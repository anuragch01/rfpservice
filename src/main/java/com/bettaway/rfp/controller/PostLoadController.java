package com.bettaway.rfp.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bettaway.rfp.modal.Address;
import com.bettaway.rfp.modal.PostLoad;
import com.bettaway.rfp.modal.PostLoad.BidAcceptanceMethod;
import com.bettaway.rfp.modal.PostLoad.DropLive;
import com.bettaway.rfp.modal.PostLoad.PostingMethod;
import com.bettaway.rfp.modal.PostLoad.Preferences;
import com.bettaway.rfp.modal.PostLoad.Status;
import com.bettaway.rfp.response.ResponseBean;

@RestController
@RequestMapping("/postLoad/")
public class PostLoadController {

	@PostMapping("create")
	ResponseEntity<ResponseBean> savePostLoad(@RequestHeader(name = "authId") String authId,
			@RequestHeader("role") String role, @RequestBody PostLoad reqPostLoad) {
		return ResponseEntity.ok(ResponseBean.success("Post added successfully"));
	}

	@GetMapping("list")
	ResponseEntity<ResponseBean> listPostLoad(@RequestHeader(name = "authId") String authId,
			@RequestHeader("role") String role) {
		PostLoad postLoad1 = PostLoad.createBuilder().setTitle("PL 1").setShipperName("Name 1")
				.setId(new ObjectId().toHexString())
				.setShippingAddress(
						Address.createBuilder().setCity("city 1").setCountry("US").setLine2("lane2")
						.setState("state1").setZip("233232")
						.setLine1("adderss1").build())
				.setQuantity(10).setNotes("sample notes").setDisplayCostToMarketPrice(true)
				.setBidCloseTime(LocalDateTime.now()).setBasePrice(100.0d)
				.setPostingMethod(PostingMethod.MARKET.getCode()).setCommodity("commodity 1")
				.setDeliveryWindowBegin(LocalTime.now()).setDeliveryWindowEnd(LocalTime.now())
				.setDropLive(DropLive.DROP.getCode()).setRequestDeliveryDate(LocalDate.now()).setGrade("grade 1")
				.setAppt1(LocalTime.now()).setAppt2(LocalTime.now())
				.setStatus(Status.PENDING.getCode())
				.setPreferences(Preferences.VAN.getCode())
				.setBidAcceptanceMethod(BidAcceptanceMethod.UNDER_TARGET_THRESHOLD.getCode())
				.build();
		PostLoad postLoad2 = PostLoad.createBuilder().setTitle("PL 1").setShipperName("Name 1")
				.setId(new ObjectId().toHexString())
				.setShippingAddress(
						Address.createBuilder().setCity("city 1").setCountry("US").setLine2("lane2")
						.setState("state1").setZip("233232")
						.setLine1("adderss1").build())
				.setQuantity(10).setNotes("sample notes").setDisplayCostToMarketPrice(true)
				.setBidCloseTime(LocalDateTime.now()).setBasePrice(100.0d)
				.setPostingMethod(PostingMethod.MARKET.getCode()).setCommodity("commodity 1")
				.setDeliveryWindowBegin(LocalTime.now()).setDeliveryWindowEnd(LocalTime.now())
				.setDropLive(DropLive.LIVE.getCode()).setRequestDeliveryDate(LocalDate.now()).setGrade("grade 1")
				.setAppt1(LocalTime.now()).setAppt2(LocalTime.now())
				.setStatus(Status.PENDING.getCode())
				.setPreferences(Preferences.FLAT_BED.getCode())
				.setBidAcceptanceMethod(BidAcceptanceMethod.APPROVE_AND_ACCEPT.getCode())
				.build();
		
		return ResponseEntity.ok(ResponseBean.success(Arrays.asList(postLoad1, postLoad2), "List Post Load"));
	}

	@GetMapping("search")
	ResponseEntity<ResponseBean> searchPostLoad(@RequestHeader(name = "authId") String authId,
			@RequestHeader("role") String role, @RequestParam(required = true, name = "title") String title) {
		System.out.println("searching for post load");
		return listPostLoad(authId, role);
	}
}
