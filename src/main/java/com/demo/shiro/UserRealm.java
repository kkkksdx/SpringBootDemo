package com.demo.shiro;

//
//import com.qinjingcao.finance.common.LockHelper;
//import com.qinjingcao.finance.entity.Admin;
//import com.qinjingcao.finance.entity.AdminPermissions;
//import com.qinjingcao.finance.entity.User;
//import com.qinjingcao.finance.entity.UserPermissions;
//import com.qinjingcao.finance.service.AdminPermissionsService;
//import com.qinjingcao.finance.service.AdminService;
//import com.qinjingcao.finance.service.UserPermissionsService;
//import com.qinjingcao.finance.service.UserService;
import com.demo.pojo.Admin;
import com.demo.pojo.AdminPermissions;
import com.demo.pojo.User;
import com.demo.pojo.UserPermissions;
import com.demo.service.AdminPermissionsService;
import com.demo.service.AdminService;
import com.demo.service.UserPermissionsService;
import com.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import java.util.List;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    UserPermissionsService userPermissionsService;
    @Autowired
    AdminPermissionsService adminPermissionsService;
//执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //System.out.println("执行了=>授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

//        info.addStringPermission("user:add");
        //获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();

        String currentUserUsername = (String) subject.getPrincipal();
        User user = userService.selectUserByUserName(currentUserUsername);
        if (user!=null){
            info.addRole("admin");
            info.addRole("user");
            List<UserPermissions> list = userPermissionsService.selectUserPermissionsByUserId(1);
            List<AdminPermissions> list2 = adminPermissionsService.selectAdminPermissionsByUserId(1);

            //System.out.println(list);
            for (UserPermissions up:list) {
                info.addStringPermission(up.getPermission());
            }
            for (AdminPermissions ap:list2) {
                info.addStringPermission(ap.getPermission());
            }
        }

        String currentAdminUsername = (String) subject.getPrincipal();
        Admin admin = adminService.selectUserByUserName(currentAdminUsername);
        if (admin!=null){
            info.addRole("admin");
            info.addRole("user");
            List<AdminPermissions> list2 = adminPermissionsService.selectAdminPermissionsByUserId(1);
            List<UserPermissions> list = userPermissionsService.selectUserPermissionsByUserId(1);

            //System.out.println(list);
            for (AdminPermissions ap:list2) {
                info.addStringPermission(ap.getPermission());
            }
            for (UserPermissions up:list) {
                info.addStringPermission(up.getPermission());
            }
        }
       //info.addStringPermission(currentUser.getPrams());

        return info;
    }
//执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {


        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        //从token中取到用户名再去查用户密码
        //User user = userService.queryUserByName(userToken.getUsername());
        User user = userService.selectUserByUserName(userToken.getUsername());
        if (user != null) {
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            user.setStatus(1);
            userService.updateUser(user);
            session.setAttribute("loginUser", user);
            System.out.println("执行了=>认证=>"+user.getUsername()+"登录进入系统");
           // System.out.println(user.getPassword());
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "");
        }

        Admin admin = adminService.selectUserByUserName(userToken.getUsername());
        if (admin!=null){
            Subject currentSubject = SecurityUtils.getSubject();
            Session session = currentSubject.getSession();
            admin.setStatus(1);
            adminService.updateAdmin(admin);
            session.setAttribute("loginAdmin", admin);
            System.out.println("执行了=>认证=>"+admin.getUsername()+"登录进入系统");
            return new SimpleAuthenticationInfo(admin.getUsername(),admin.getPassword(),"");
        }
        //System.out.println("ok");
        return null;
    }
}
