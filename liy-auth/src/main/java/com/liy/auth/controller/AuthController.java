package com.liy.auth.controller;

import com.liy.auth.form.LoginBody;
import com.liy.auth.service.AuthService;
import com.liy.auth.service.TokenService;
import com.liy.common.core.web.controller.BaseController;
import com.liy.common.core.web.domain.AjaxResult;
import com.liy.model.user.auth.AuthAccountInfoPo;
import com.liy.model.user.auth.token.TokenInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author LiY
 * 用户认证
 *
 */

@RestController
//@Tag(name = "系统登录接口")
@Slf4j
public class AuthController extends BaseController {

    @Autowired
    private AuthService loginService;

    @Autowired
    private TokenService tokenService;


    /**
     * @description: 获取验证码图片
     * @author: liy
     * @param: null
     * @return:  AjaxResult
     **/
//    @Operation(summary = "获得验证码", description = "验证码以Base64格式图片传回，uuid为该验证码唯一标识")
    @GetMapping("/captchaImg")
    public AjaxResult captchaImg(){
        AjaxResult ajaxResult = toSuccess("wwwww");

//        //随机id
//        String uuid = uuidUtil.randomUUID();
//
//        //获取图片
//        BufferedImage image = loginService.getCaptchaImg(uuid);
//
//        //图片类型转换
//        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
//        try
//        {
//            ImageIO.write(image, "jpg", os);
//        }
//        catch (IOException e)
//        {
//            return AjaxResult.error(e.getMessage());
//        }
//        String img_Base64 = Base64.encode(os.toByteArray());
//
//        ajaxResult.put("img", img_Base64);
//        ajaxResult.put("uuid",uuid);
        return ajaxResult;
    }

    @PostMapping("/login")
//    @Operation(summary = "用户登录", description = "登录成功返回token")
    public AjaxResult login(@Validated @RequestBody LoginBody loginUser){
        log.info("loginUserDto:   "+loginUser.toString());

        AuthAccountInfoPo authAccountInfoPo = loginService.login(loginUser.getUserName(), loginUser.getPassword(), loginUser.getSysType());
        log.info(authAccountInfoPo.toString());
        TokenInfoVo token = tokenService.createTokenVoByUserInfo(authAccountInfoPo);

        return toSuccess().put("token", token);
    }

    @GetMapping("/info")
//    @Operation(summary = "登录成功返回用户信息")
    public AjaxResult info(){

        // 用户信息
//        UserVo userVo = userService.getUserInfo();
//        AjaxResult result = toAjaxResult("userInfo", userVo);
//        // 角色信息
//        Set<String> roles = roleService.getRoleByUser(userVo);
//        result.put("roles", roles);
        // 权限信息




        return null;
    }

    @GetMapping("/routers")
//    @Operation(summary = "获得路由信息")
    public AjaxResult routers(){

        return toSuccess();
    }

}
