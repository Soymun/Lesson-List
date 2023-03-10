package com.example.demo.Controller;


import com.example.demo.DTO.BidDto;
import com.example.demo.DTO.TypeOfBidDto;
import com.example.demo.Response.ResponseDto;
import com.example.demo.Service.Impl.BidServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ytsu")
public class BidController {

    private final BidServiceImpl bidService;

    public BidController(BidServiceImpl bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/bid")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> saveBid(@RequestBody BidDto bidDto){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.saveBid(bidDto)).build());
    }

    @PatchMapping("/bid")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateBid(@RequestBody BidDto bidDto){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.saveBid(bidDto)).build());
    }

    @DeleteMapping("/bid/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteBid(@PathVariable Long id){
        bidService.deleteBid(id);
        return ResponseEntity.ok(ResponseDto.builder().body("Suggest").build());
    }

    @GetMapping("/bid/user/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getBiByUserId(@PathVariable Long id){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.getBidByUserId(id)).build());
    }

    @GetMapping("/bid/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getBiById(@PathVariable Long id){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.getBidDtoById(id)).build());
    }

    @PostMapping("/typeOfBid")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> saveTypeOfBid(@RequestBody TypeOfBidDto bidDto){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.saveTypeOfBid(bidDto)).build());
    }

    @PatchMapping("/typeOfBid")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> updateTypeOfBid(@RequestBody TypeOfBidDto bidDto){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.updateTypeOfBid(bidDto)).build());
    }

    @DeleteMapping("/typeOfBid/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> deleteTypeOfBid(@PathVariable Long id){
        bidService.deleteTypeOfBid(id);
        return ResponseEntity.ok(ResponseDto.builder().body("Suggest").build());
    }

    @GetMapping("/typeOfBid")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getTypeOfBids(){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.getListTypeOfBid()).build());
    }

    @GetMapping("/typeOfBid/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<?> getTypeOfBidById(@PathVariable Long id){
        return ResponseEntity.ok(ResponseDto.builder().body(bidService.getTypeOfBid(id)).build());
    }
}
