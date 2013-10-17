/**
 * User: Alexey Nevinsky
 * Date: 06.07.13 22:35
 */
define([
    "dojo/_base/declare", "dojo/_base/lang", "dojo/Evented",
], function (declare, lang, Evented) {
    return declare("controllers.common.AbstractController", [Evented], {

        _viewTemplateString: "",

        constructor: function (options) {
            lang.mixin(this, options);
        },
        _getTemplateString: function () {
            var template, self = this;
            var xhrArgs = {
                url: self._viewTemplateString,
                handleAs: "text",
                sync: true,
                preventCache: true,
                load: function (data) {
                    template = data;
                },
                error: function () {
//                    TODO show '((('-dialog
                }
            };
//            TODO: do asinc this
            dojo.xhrGet(xhrArgs);
            return template;
        }
    });
});