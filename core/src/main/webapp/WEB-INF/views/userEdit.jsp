<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<div id="userEditController">
    <%--<form data-dojo-type="dojox/form/Manager">--%>
    <form data-dojo-type="dojox/mvc/Group" data-dojo-props="target: at(this.ctrl,'model')">
        <input type="text" data-dojo-attach-point="id" data-dojo-type="dijit/form/TextBox"
               data-dojo-props="value: at('rel:', 'id')"/>
        <input type="button" data-dojo-attach-point="submitButton" data-dojo-type="dijit/form/Button"/>
        <input type="button" data-dojo-attach-point="cancelButton" data-dojo-type="dijit/form/Button"/>
    </form>
</div>