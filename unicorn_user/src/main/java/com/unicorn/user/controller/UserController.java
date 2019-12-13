package com.unicorn.user.controller;

import com.unicorn.user.pojo.User;
import com.unicorn.user.service.UserService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import util.JwtUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static com.unicorn.user.util.MyUtils.getIpAddr;


/**
 * @Author:wangsusheng
 * @Date: 2019/10/18 16:38
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "UserController", description = "用户相关")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private  JwtUtil jwtUtil;


    /**
     * 发送短信验证码
     */
    @ApiOperation(value = "用户发送短信验证码", notes = "用户发送短信验证码")
    @RequestMapping(value = "/sendsms/{mobile}", method = RequestMethod.POST)
    public Result sendSms(@PathVariable String mobile) {

        return new Result(true, StatusCode.OK, userService.sendSms(mobile).getMessage(),userService.sendSms(mobile));
    }

    /**
     * 注册
     *
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "/register/{code}", method = RequestMethod.POST)
    public Result regist(@PathVariable String code, @RequestBody User user, HttpServletRequest request) {
        //得到缓存中的验证码
        String checkcodeRedis = (String) redisTemplate.opsForValue().get("smscode_" + user.getMobile());
        if (checkcodeRedis.isEmpty()) {
            return new Result(false, StatusCode.ERROR, "请先获取手机验证码");
        }
        if (!checkcodeRedis.equals(code)) {
            return new Result(false, StatusCode.ERROR, "请输入正确的验证码");
        }
        user.setLastdate(new Date());
        user.setLoginip(getIpAddr(request));
        userService.add(user, code);
        return new Result(true, StatusCode.OK, "注册成功");
    }

    /**
     * 更新好友粉丝数和用户关注数
     * @return
     */
    @ApiOperation(value="更新好友粉丝数和用户关注数",notes = "更新好友粉丝数和用户关注数")
    @RequestMapping(value = "/{userid}/{friendid}/{x}", method = RequestMethod.PUT)
    public void updatefanscountandfollowcount(@PathVariable String userid, @PathVariable String friendid, @PathVariable int x){
        userService.updatefanscountandfollowcount(x,userid,friendid);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @ApiOperation(value="用户登录",notes = "用户登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user){
        user = userService.login(user.getMobile(), user.getPassword());
        if(user==null){
            return new Result(false, StatusCode.LOGINERROR, "登录失败");
        }
        String token = jwtUtil.createJWT(user.getId(), user.getMobile(), "user");
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("roles", "user");
        return new Result(true, StatusCode.OK, "登录成功", map);
    }

    /**
     * 查询全部数据
     *
     * @return
     */
    @ApiOperation(value = "查询全部用户数据", notes = "查询全部用户数据")
    @RequestMapping(value = "findAll", method = RequestMethod.GET)
    public Result findAll() {
        return new Result(true, StatusCode.OK, "查询成功", userService.findAll());
    }

    /**
     * 根据ID查询
     *
     * @param id ID
     * @return
     */
    @ApiOperation(value = "根据ID查询用户", notes = "根据ID查询用户")
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findById(id));
    }


    /**
     * 分页+多条件查询
     *
     * @param searchMap 查询条件封装
     * @param page      页码
     * @param size      页大小
     * @return 分页结果
     */
    @ApiOperation(value = "分页+多条件查询用户", notes = "分页+多条件查询用户")
    @RequestMapping(value = "/search/{page}/{size}", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<User> pageList = userService.findSearch(searchMap, page, size);
        return new Result(true, StatusCode.OK, "查询成功", new PageResult<User>(pageList.getTotalElements(), pageList.getContent()));
    }

    /**
     * 根据条件查询
     *          0
     * @param searchMap
     * @return
     */
    @ApiOperation(value = "根据条件查询用户", notes = "根据条件查询用户")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public Result findSearch(@RequestBody Map searchMap) {
        return new Result(true, StatusCode.OK, "查询成功", userService.findSearch(searchMap));
    }

    /**
     * 增加
     *
     * @param user
     */
    @ApiOperation(value = "增加用户", notes = "增加用户")
    @RequestMapping(value = "/add/{code}", method = RequestMethod.POST)
    public Result add(@RequestBody User user, @PathVariable String code) {
        userService.add(user, code);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改
     *
     * @param user
     */
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody User user, @PathVariable String id) {
        user.setId(id);
        userService.update(user);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除 必须有admin角色才能删除
     *
     * @param id
     */
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        userService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

//    @ApiOperation(value="用户登录",notes = "用户登录")
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public Result login(@RequestBody User user,HttpServletRequest  request){
//
//        userService.updateUser(new Date(),getIpAddr(request),user.getMobile());
//        user = userService.login(user.getMobile(), user.getPassword());
//        if(user==null){
//            return new Result(false, StatusCode.LOGINERROR, "登录失败");
//        }
//        String token = jwtUtil.createJWT(user.getId(), user.getMobile(), "user");
//        Map<String, Object> map = new HashMap<>();
//        map.put("roles", "user");
//        map.put("token",token);
//        return new Result(true, StatusCode.OK, "登录成功", map);
//    }
}
