<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf8" %>
<div style="height: 100%; width: 100%">
    <div id="userBrowserLayout" data-dojo-type="dijit/layout/LayoutContainer" data-dojo-attach-point="layout"
         data-dojo-props="design:'headline'" style="height:100%">
        <div class="${baseClass}Title" data-dojo-attach-point="titleNode" data-dojo-type="dijit.layout.ContentPane"
             data-dojo-props="region:'top'">
            <button data-dojo-attach-point="createButton" data-dojo-type="dijit/form/ToggleButton">Create</button>
            <button data-dojo-attach-point="editButton" data-dojo-type="dijit/form/ToggleButton">Edit</button>
            <button data-dojo-attach-point="removeButton" data-dojo-type="dijit/form/ToggleButton">Remove</button>
            <button data-dojo-attach-point="refreshButton" data-dojo-type="dijit/form/ToggleButton">Refresh</button>
        </div>
        <div data-dojo-type="dijit.layout.ContentPane" class="${baseClass}Container"
             data-dojo-attach-point="containerNode" data-dojo-props="region:'center'">
            <table id="usersGrid" data-dojo-type="dojox.grid.DataGrid" data-dojo-attach-point="usersGrid"
                   data-dogo-id="grid" class="grid" style="height:100%;">
                <thead>
                <tr>
                    <th field="firstname" width="280px">Firstname</th>
                    <th field="middlename" width="280px">Middlename</th>
                    <th field="lastname" width="280px">Lastname</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>