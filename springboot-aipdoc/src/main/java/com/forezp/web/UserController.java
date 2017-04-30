package com.forezp.web;

import org.springframework.web.bind.annotation.*;

/**
 * 先安装node.js
 * 在安装apidoc
 * Created by fangzhipeng on 2017/4/17.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    /**
     * @api {get} /user/:id  获取用户信息
     * @apiName GetUser
     * @apiGroup User
     *
     * @apiParam {Number} id Users unique ID.
     *
     * @apiSuccess {String} firstname Firstname of the User.
     * @apiSuccess {String} lastname  Lastname of the User.
     *
     * @apiSuccessExample Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *       "firstname": "John",
     *       "lastname": "Doe"
     *     }
     *
     * @apiError UserNotFound The id of the User was not found.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "UserNotFound"
     *     }
     */
    @RequestMapping (value = "/{id}",method = RequestMethod.GET)
    public String getUser(@PathVariable(name = "id")long  id){
            return "用户id为"+id;
    }


    /**
     * @api {get} /user/:id Request User information
     * @apiName GetUser
     * @apiGroup User
     *
     * @apiParam {Number} id Users unique ID.
     *
     * @apiSuccess {String} firstname Firstname of the User.
     * @apiSuccess {String} lastname  Lastname of the User.
     *
     * @apiSuccessExample Success-Response:
     *     HTTP/1.1 200 OK
     *     {
     *       "firstname": "John",
     *       "lastname": "Doe"
     *     }
     *
     * @apiError UserNotFound The id of the User was not found.
     *
     * @apiErrorExample Error-Response:
     *     HTTP/1.1 404 Not Found
     *     {
     *       "error": "UserNotFound"
     *     }
     */
    @RequestMapping (value = "/{id}",method = RequestMethod.PUT)
    public String updateUserName(@PathVariable(name = "id")long  id, String name){
        return "用户id为"+id+",name:"+name;
    }


    /**
     * @api {POST} /register 注册用户
     * @apiGroup Users
     * @apiVersion 0.0.1
     * @apiDescription 用于注册用户
     * @apiParam {String} account 用户账户名
     * @apiParam {String} password 密码
     * @apiParam {String} mobile 手机号
     * @apiParam {int} vip = 0  是否注册Vip身份 0 普通用户 1 Vip用户
     * @apiParam {String} [recommend] 邀请码
     * @apiParamExample {json} 请求样例：
     *                ?account=sodlinken&password=11223344&mobile=13739554137&vip=0&recommend=
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 0 代表无错误 1代表有错误
     * @apiSuccessExample {json} 返回样例:
     *                {"code":"0","msg":"注册成功"}
     */

    /**
     * @api {POST} /login 用户登录
     * @apiGroup Users
     * @apiVersion 0.0.1
     * @apiDescription 用于用户登录
     * @apiParam {String} userName 用户名
     * @apiParam {String} password 密码
     * @apiParamExample {json} 请求样例：
     *                ?userName=张三&password=11223344
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {String} code 0 代表无错误 1代表有错误
     * @apiSuccess (200) {String} user 用户信息
     * @apiSuccess (200) {String} userId 用户id
     * @apiSuccessExample {json} 返回样例:
     *                {"code":"0","msg":"登录成功","userId":"fe6386d550bd434b8cd994b58c3f8075"}
     */

    /**
     * @api {GET} /users/:id 获取用户信息
     * @apiGroup Users
     * @apiVersion 0.0.1
     * @apiDescription 获取用户信息
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 0 代表无错误 1代表有错误
     * @apiSuccess (200) {String} name 真实姓名
     * @apiSuccess (200) {String} mobile 手机号
     * @apiSuccess (200) {String} birthday 生日
     * @apiSuccess (200) {String} email 邮箱
     * @apiSuccess (200) {String} summary 简介
     * @apiSuccess (200) {String} recommendCode 我的推荐码
     * @apiSuccess (200) {String} idCardNo 身份证号
     * @apiSuccess (200) {String} memberState 会员状态 0普通用户 1VIP 2账户冻结
     * @apiSuccess (200) {String} address 家庭住址
     * @apiSuccess (200) {String} money 账户现金
     * @apiSuccessExample {json} 返回样例:
     * {
     *   "code": 0,
     *   "msg": "",
     *   "name": "真实姓名",
     *   "mobile": 15808544477,
     *   "birthday": "1990-03-05",
     *   "email": "slocn@gamil.com",
     *   "summary": "简介",
     *   "recommendCode": "我的推荐码",
     *   "idCardNo": "身份证号",
     *   "memberState": 1,
     *   "address": "家庭住址",
     *   "money": "30.65"
     * }
     */


    /**
     * @api {POST} /users/:id 修改(完善)用户信息
     * @apiGroup Users
     * @apiVersion 0.0.1
     * @apiDescription 修改(完善)用户信息
     * @apiParam (200) {String} [name] 真实姓名
     * @apiParam (200) {String} [mobile] 手机号
     * @apiParam (200) {String} [birthday] 生日
     * @apiParam (200) {String} [email] 邮箱
     * @apiParam (200) {String} [summary] 简介
     * @apiParam (200) {String} [idCardNo] 身份证号
     * @apiParam (200) {String} [address] 家庭住址
     * @apiSuccess (200) {String} msg 信息
     * @apiSuccess (200) {int} code 0 代表无错误 1代表有错误
     * @apiSuccessExample {json} 返回样例:
     *                {"code":"0","msg":"修改成功"}
     */
}
