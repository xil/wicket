<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<%--<div id="userEditView" data-dojo-type="dijit/Dialog" title="Accept or decline agreement terms" style="width:400px;">--%>
<div id="userEditView">
    <%--<form data-dojo-type="dojox/form/Manager">--%>
    <div class="dijitDialogPaneContentArea">
        <form data-dojo-type="dijit/form/Form" data-dojo-attach-point="form">
            <div data-dojo-attach-point="contentNode" data-dojo-type="dojox/mvc/Group"
                 data-dojo-props="target: at(this.ctrl,'model')">

                <table class="form">
                    <tr>
                        <%--TODO i18n!!!!!--%>
                        <td>First Name</td>
                        <td>
                            <input type="text" data-dojo-attach-point="firstname"
                                   data-dojo-type="dijit/form/ValidationTextBox"
                                   data-dojo-props="value: at('rel:', 'firstname'), required: true, maxLength: 64, trim: true"
                                   style="width:100%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Middle Name</td>
                        <td>
                            <input type="text" data-dojo-attach-point="firstname"
                                   data-dojo-type="dijit/form/ValidationTextBox"
                                   data-dojo-props="value: at('rel:', 'middlename'), required: true, maxLength: 64, trim: true"
                                   style="width:100%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td>
                            <input type="text" data-dojo-attach-point="firstname"
                                   data-dojo-type="dijit/form/ValidationTextBox"
                                   data-dojo-props="value: at('rel:', 'lastname'), required: true, maxLength: 64, trim: true"
                                   style="width:100%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Scans</td>
                        <td>
                            <%--<span>--%>
                            <%--TODO--%>
                            <%--1 of 3--%>
                            <%--</span>--%>
                            <%--<button data-dojo-type="dijit/form/Button" data-dojo-attach-point="removeLastButton"--%>
                            <%--data-dojo-props="disabled:true">--%>
                            <%--Remove last--%>
                            <%--</button>--%>
                            <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="scanningButton"
                                    width="100%">
                                Scanning
                            </button>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <span id="errMessageBox" style="width: 100%;"/>
                        </td>
                    </tr>
                </table>
            </div>
        </form>

    </div>
    <div class="dijitDialogPaneActionBar">
        <div class="message" data-dojo-attach-point="messageNode"></div>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="commitButton">
            OK
        </button>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="cancelButton">
            Cancel
        </button>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="applyButton">
            Apply
        </button>
    </div>
</div>