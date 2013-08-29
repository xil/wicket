<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%--<div id="userEditView" data-dojo-type="dijit/Dialog" title="Accept or decline agreement terms" style="width:400px;">--%>
<div id="userEditView">
    <%--<form data-dojo-type="dojox/form/Manager">--%>
    <div class="dijitDialogPaneContentArea">
        <div data-dojo-attach-point="contentNode">
            <form data-dojo-type="dojox/mvc/Group" data-dojo-props="target: at(this.ctrl,'model')">
                <input type="text" data-dojo-attach-point="firstname" data-dojo-type="dijit/form/TextBox"
                       data-dojo-props="value: at('rel:', 'firstname')"/>
                <input type="text" data-dojo-attach-point="middlename" data-dojo-type="dijit/form/TextBox"
                       data-dojo-props="value: at('rel:', 'middlename')"/>
                <input type="text" data-dojo-attach-point="lastname" data-dojo-type="dijit/form/TextBox"
                       data-dojo-props="value: at('rel:', 'lastname')"/>
                <%--<input type="button" data-dojo-attach-point="commitButton" data-dojo-type="dijit/form/Button"/>--%>
                <%--<input type="button" data-dojo-attach-point="cancelButton" data-dojo-type="dijit/form/Button"/>--%>
            </form>
        </div>
    </div>
    <div class="dijitDialogPaneActionBar">
        <div class="message" data-dojo-attach-point="messageNode"></div>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="commitButton">
            OK
        </button>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="cancelButton">
            Cancel
        </button>
    </div>
</div>