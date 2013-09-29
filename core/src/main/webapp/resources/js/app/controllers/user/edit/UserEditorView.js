/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented",
    "views/common/AbstractView"
    , "dijit/Dialog", "dojox/mvc/Group", "dijit/form/Form", "dijit/form/ValidationTextBox"
], function (declare, lang, Evented, AbstractView, Dialog, Group) {
    return declare([Dialog, Evented], {

        constructor: function (options) {
            lang.mixin(this, options);

            var initParams = this.contentParams;
            this.ctrl = initParams.ctrl;
            var contentWidget = new (declare([AbstractView],
                {
                    templateString: initParams.templateString,
                    ctrl: initParams.ctrl
                }
            ));
            contentWidget.startup();
            var content = this.content = contentWidget;
        },
        postCreate: function () {
            this.inherited(arguments);

            var commitButton = this.content.commitButton;
            this.connect(commitButton, "onClick", "commit");
            commitButton.set("label", "Commit");
            var cancelButton = this.content.cancelButton;
            this.connect(cancelButton, "onClick", "cancel");

//                var self = this;
//                var contentWidget = new (declare([AbstractView],
//                    {
//                        templateString: self.templateString
//                    }
//                ));
//                contentWidget.startup();
//                var content = this.content = contentWidget;

        },
        commit: function () {
//            TODO check validation
            if (this.content.form.validate()) {
                this.ctrl.commit();
                this.hide();
                this.emit("commitAction", {});
            }
        },
        cancel: function () {
            this.hide();
            this.emit("closeAction", {});
        }
    });
});