<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header" >
                        <div class="dropdown profile-element">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">

                               <span class="block m-t-xs"><strong class="font-bold">${SESSION_USER.role.rName }</strong></span>
                                <span class="text-muted text-xs block">${SESSION_USER.uName }<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">

                                <li><a class="J_menuItem" href="user/sysUserPassword.html">修改密码</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="login/logout.html">安全退出</a>
                                </li>
                            </ul>
                        </div>

                    </li>
                    <c:forEach items="${menus }" var="menu">
                    	<c:if test="${menu.mParentId == '0' }">
		                    <li>
		                        <a href="#">
		                            <i class="${menu.mIcon }"></i>
		                            <span class="nav-label">${menu.mName }</span>
		                            <span class="fa arrow"></span>
		                        </a>
		                        <ul class="nav nav-second-level">
		                        	<c:forEach items="${menus }" var="zmenu">
		                        		<c:if test="${zmenu.mParentId ==  menu.mId}">
		                        			<li>
		                               	 		<a class="J_menuItem" href="${zmenu.mPath }" data-index="0">${zmenu.mName }</a>
		                            		</li>
		                        		</c:if>
		                        	</c:forEach>
		                        </ul>
		                    </li>
	                    </c:if>
					</c:forEach>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->