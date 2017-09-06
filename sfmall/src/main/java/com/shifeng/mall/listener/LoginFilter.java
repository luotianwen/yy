package com.shifeng.mall.listener;

import com.shifeng.mall.entity.user.Users;
import com.shifeng.mall.util.UrlUtil;
import com.shifeng.util.Common;
import com.shifeng.util.Const;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AssertionHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录过滤
 */
public class LoginFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // 从session中获取登录者实体
        Object obj = request.getSession().getAttribute(Const.MALL_SESSION_USER);
        if (null == obj) {
            {

                AttributePrincipal principal = AssertionHolder.getAssertion().getPrincipal();
                String username = principal.getAttributes().get("id").toString();
                String password = principal.getAttributes().get("name").toString();
                UsernamePasswordToken token = new UsernamePasswordToken(username, password);
                token.setRememberMe(true);
                // 获取当前的Subject
                Subject currentUser = SecurityUtils.getSubject();
                // 获取登录IP
                currentUser.getSession().setAttribute(Const.LOGIN_IP, Common.getRemoteAddrIp(request));
                try {
                    // 在调用了login方法后,SecurityManager会收到AuthenticationToken（验证token）,并将其发送给已配置的Realm执行必须的认证检查
                    currentUser.login(token);
                } catch (Exception e) {
                   // response.sendError(500);
                    SecurityUtils.getSubject().logout();
                    String logout = UrlUtil.getLogout();
                    response.sendRedirect(logout);
                }
            }
        } else {
            // 如果session中存在登录者实体，则继续
            filterChain.doFilter(request, response);
        }


    }
}
