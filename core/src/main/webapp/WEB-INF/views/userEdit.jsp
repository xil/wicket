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
                        <td>\${i18n.firstName}</td>
                        <td>
                            <input type="text" data-dojo-attach-point="firstname"
                                   data-dojo-type="dijit/form/ValidationTextBox"
                                   data-dojo-props="value: at('rel:', 'firstname'), required: true, maxLength: 64, trim: true"
                                   style="width:100%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>\${i18n.middleName}</td>
                        <td>
                            <input type="text" data-dojo-attach-point="middlename"
                                   data-dojo-type="dijit/form/ValidationTextBox"
                                   data-dojo-props="value: at('rel:', 'middlename'), required: true, maxLength: 64, trim: true"
                                   style="width:100%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>\${i18n.lastName}</td>
                        <td>
                            <input type="text" data-dojo-attach-point="lastname"
                                   data-dojo-type="dijit/form/ValidationTextBox"
                                   data-dojo-props="value: at('rel:', 'lastname'), required: true, maxLength: 64, trim: true"
                                   style="width:100%"/>
                        </td>
                    </tr>
                    <tr>
                        <td>\${i18n.userRole}</td>
                        <td>
                            <select data-dojo-attach-point="role"
                                    data-dojo-type="dijit/form/ComboBox"
                                    data-dojo-props="disabled:true"
                                    style="width:100%">
                                <option selected>User</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>\${i18n.scans}</td>
                        <td>
                            <span data-dojo-type="dojox/mvc/Output"
                                  data-dojo-attach-point="scansCount"
                                  data-dojo-props="value: at('rel:', 'scans')"></span> \${i18n.of} 3
                            <button data-dojo-type="dijit/form/Button"
                                    data-dojo-attach-point="removeLastButton"
                                    data-dojo-props="disabled:true">
                                \${i18n.button.removeLast}
                            </button>
                            <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="scanningButton"
                                    width="100%">
                                \${i18n.button.scanning}
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
            \${i18n.button.commitAndClose}
        </button>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="cancelButton">
            \${i18n.button.cancel}
        </button>
        <button data-dojo-type="dijit/form/Button" data-dojo-attach-point="applyButton">
            \${i18n.button.apply}
        </button>
    </div>
</div>