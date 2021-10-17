
package com.io.holter.common.proxy.user;

import com.io.holter.common.component.UserDto;
import com.io.holter.common.dto.RendorProvidorDto;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "users-service")
@RibbonClient(name = "users-service")
public interface UserProxy {


	@PostMapping
	UserDto createUser(@RequestHeader("Authorization") String bearerToken, @RequestBody UserDto user) throws Exception;
	@GetMapping("username/{userName}")
	UserDto  getUserByUserName(@RequestHeader("Authorization") String bearerToken, @PathVariable String userName);
//	@GetMapping( "/{userId}")
//	 UserDto getUserById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long userId);
	@GetMapping( value = "/{userId}",produces = MediaType.ALL_VALUE)
	ResponseEntity<UserDto> getUserById(@RequestHeader("Authorization") String bearerToken, @PathVariable Long userId);
	@GetMapping("/render/{providerId}")
	public RendorProvidorDto getIndiviualRenderProviderUser(@RequestHeader("Authorization") String bearerToken, @PathVariable Long providerId);
	@GetMapping("/render/list/all")
	public List<RendorProvidorDto> getIndiviualRenderProviderUserSortList(@RequestHeader("Authorization") String bearerToken);
}
