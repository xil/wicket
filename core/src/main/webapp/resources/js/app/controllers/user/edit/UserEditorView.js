/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:37
 */
define([
    "dojo/_base/declare", "dojo/_base/lang",
    "views/common/AbstractView"
    , "dijit/Dialog"
], function (declare, lang, AbstractView, Dialog) {
        return declare([Dialog], {

            constructor: function (options) {
                lang.mixin(this, options);

                var self = this;
                var contentWidget = new (declare([AbstractView],
                    {
                        templateString: self.templateString,
                        ctrl: self.ctrl
                    }
                ));
                contentWidget.startup();
                var content = this.content = contentWidget;
            },
            postCreate: function () {
                this.inherited(arguments);

//                var self = this;
//                var contentWidget = new (declare([AbstractView],
//                    {
//                        templateString: self.templateString
//                    }
//                ));
//                contentWidget.startup();
//                var content = this.content = contentWidget;

            }
        });
    }
)
;