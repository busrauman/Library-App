<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html; charset=UTF-8"%>
<html >
<head>
<%@include file="../include/cssIncludes.jsp" %>
<%@include file="../include/javascriptIncludes.jsp" %>

</head>
	 <div id="navbar" class="navbar-inverse navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#"><fmt:message key="menu.anasayfa"/></a></li>
<!--                 <li><a href="#about">About</a></li> -->
<!--                 <li><a href="#contact">Contact</a></li> -->
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                    <fmt:message key="menu.kitap"/>
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="./create/book"><fmt:message key="menu.kitap.ekle"/></a></li>
                        <li><a href="#"><fmt:message key="menu.kitap.listesi"/></a></li>
<!--                         <li><a href="#">Something else here</a></li> -->
                        <li role="separator" class="divider"></li>
<!--                         <li class="dropdown-header">Nav header</li> -->
<!--                         <li><a href="#">Separated link</a></li> -->
<!--                         <li><a href="#">One more separated link</a></li> -->
                    </ul>
                </li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                    <fmt:message key="menu.yazar"/>
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><fmt:message key="menu.yazar.ekle"/></a></li>
                        <li><a href="#"><fmt:message key="menu.yazar.listesi"/></a></li>
                    </ul>
                </li>
                
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
                    <fmt:message key="menu.yayinevi"/>
                    <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="publisher"><fmt:message key="menu.yayinevi.ekle"/></a></li>
                        <li><a href="#"><fmt:message key="menu.yayinevi.listesi"/></a></li>                
                    </ul>
                </li>
            </ul>
</div><!--/.nav-collapse -->

</html>