window.verTree = (function () {
    var tree = function (params) {
        //加载css样式
        var path = this.getPath,
            common_css_href = path + "need/common.css?v=1.0&_=" + Math.random(),
            icon_css_href = path + "need/tree.css?v=1.0&_=" + Math.random(),
            common_link = document.createElement("link"),
            icon_link = document.createElement("link");
        common_link.href = common_css_href;
        icon_link.href = icon_css_href;
        common_link.rel = icon_link.rel = "stylesheet";
        common_link.type = icon_link.type = "text/css";
        var link = document.getElementsByTagName("head")[0];
        link.appendChild(common_link);
        link.appendChild(icon_link);
        this.tree = document.querySelector(params.items);
        this.tree.classList.add("tree-" + params.type);
        this.data = params.data;
        this.type = params.type ? params.type : "data";
        this.option = params.option ? params.option : "";
        this.pk = params.parent ? params.parent : "parent";
        this.id = params.params ? params.params : "id";
        this.name = params.name ? params.name : "name";
        switch (this.type) {
            case "list":
                this.thead = (this.tree).querySelector('[data-tree-list="true"]');
                this.table_tree();
                break;
            case "form":
                this.items();
                break;
            default:
                this.items();
                break;
        }
    };
    tree.prototype = {
        getPath: function () {
            var jsPath = document.currentScript ? document.currentScript.src : function () {
                var js = document.scripts
                    , last = js.length - 1
                    , src;
                for (var i = last; i > 0; i--) {
                    if (js[i].readyState === 'interactive') {
                        src = js[i].src;
                        break;
                    }
                }
                return src || js[last].src;
            }();
            return jsPath.substring(0, jsPath.lastIndexOf('/') + 1);
        }(),
        items: function () {
            this.tree.classList.add("tree-form-box");
            this.tree_data(this.data, 0);
            if (this.type == "form") {
                this.checkInput();
            }
            this.tree_options_list();
        },
        tree_data: function (data, level, cl) {
            var ul = document.createElement("ul");
            var f = level + 1;
            var icons = icon = "";
            for (var i in data) {
                var d = data[i];
                if (d.children.length > 0) {
                    icon = "<i class='verTreeIcon icon-minus green tree-option'></i>";
                }

                if (this.type == "form") {
                    icons = "<span><i class='verTreeIcon icon-check-box blue ver-tree-check ver-tree-checks'></i><input type='checkbox' name='" + this.id + "[]' value='" + d[this.id] + "' style='display: none'></span> "
                }
                var li = document.createElement("li");
                li.setAttribute("data-parent", d[this.pk]);
                li.setAttribute("data-id", d[this.id]);
                li.setAttribute("data-level", level);
                li.innerHTML = icon + icons + d[this.name];
                li.className = "ver-tree-levels ver-tree-level-" + level + " tree-parent-" + d[this.pk];
                ul.appendChild(li);
                if (cl) {
                    cl.appendChild(ul);
                } else {
                    this.tree.appendChild(ul);
                }
                if (d.children.length > 0) {
                    this.tree_data(d.children, f, li);
                }
            }
        },
        /*
         * 表格列表以树形菜单排列
         */
        table_tree: function () {
            var child = this.thead.querySelectorAll("[data-field]");
            var changes = this.thead.getAttribute("data-tree-changes");
            if (changes) {
                var cha = document.createElement("th");
                cha.innerHTML = "<i class='verTreeIcon icon-check-box blue ver-tree-check-all ver-tree-checks'></i>";
                cha.width = 30;
                this.thead.insertBefore(cha, this.thead.children[0])
            }
            var chas = document.createElement("th");
            this.thead.insertBefore(chas, this.thead.children[0]);
            chas.style.width = "5em";
            var html = this.list_item(this.data, child, 0, changes);
            var tbody = document.createElement("tbody");
            tbody.innerHTML = html;
            this.tree.appendChild(tbody);
            this.tree_options_list();
            this.checkInput();
        },
        /*
         * 表格数据处理
         */
        list_item: function (info, child, level, changes, objs) {
            var html = "";
            var l = "";
            if (level > 0) {
                l = "|";
                for (var j = 0; j < level; j++) {
                    l += "——"
                }
            }
            var sel = this;
            for (var i in info) {
                var data = info[i];
                var childs = "";
                var _h = "";
                if (level > 0) {
                    _h = l;
                }
                if (data.children.length > 0) {
                    _h += "<i class='verTreeIcon icon-plus green tree-option'></i>";
                    childs = JSON.stringify(data.children);
                }
                var cl = "";
                if (data[this.pk] > 0) {
                    cl = " tree-parent-" + data[this.pk];
                }
                if (!objs) {
                    html += "<tr class='ver-tree-levels ver-tree-level-" + level + cl + "' data-parent='" + data[this.pk] + "' data-id='" + data[this.id] + "'><td data-levels='" + level + "'>" + _h + "<children-jsons>" + childs + "</children-jsons></td>";
                    if (changes) {
                        html += "<td align='center'><i class='verTreeIcon icon-check-box blue ver-tree-check ver-tree-checks'></i><input type='checkbox' name='" + this.id + "[]' value='" + data[this.id] + "' style='display: none'></td>"
                    }
                    child.forEach(function (item) {
                        var file = item.getAttribute("data-field");
                        html += '<td>' + data[file] + '</td>';
                    });
                    html += "</tr>";
                } else {
                    var te = document.createElement("tr");
                    te.className = "ver-tree-levels ver-tree-level-" + level + cl;
                    te.setAttribute("data-parent", data[this.pk]);
                    te.setAttribute("data-id", data[this.id]);
                    html = "<td data-levels='" + level + "'>" + _h + "<children-jsons>" + childs + "</children-jsons></td>";
                    if (changes) {
                        html += "<td align='center'><i class='verTreeIcon icon-check-box blue ver-tree-check ver-tree-checks'></i><input type='checkbox' name='" + this.id + "[]' value='" + data[this.id] + "' style='display: none'></td>"
                    }
                    child.forEach(function (item) {
                        var file = item.getAttribute("data-field");
                        html += '<td>' + data[file] + '</td>';
                    });
                    te.innerHTML = html;
                    sel.insertAfter(te, objs);
                }
            }

            return html;
        },
        insertAfter: function (newElement, targentElement) {
            var parent = targentElement.parentNode;
            if (parent.lastChild == targentElement) {
                parent.appendChild(newElement);
            } else {
                parent.insertBefore(newElement, targentElement.nextSibling)
            }
        },
        /*
         * 收缩菜单控件
         */
        tree_options_list: function () {
            if (this.type == "list") {
                var child = this.thead.querySelectorAll("[data-field]");
                var changes = this.thead.getAttribute("data-tree-changes");
            }
            var options = this.tree.querySelectorAll(".tree-option");
            var _self = this;
            options.forEach(function (item) {
                item.onclick = function (e) {
                    if (_self.type == "list") {
                        var level = parseInt(this.parentElement.getAttribute("data-levels"));
                        var id = (this.parentElement.parentElement.getAttribute("data-id"));
                        var data = this.parentElement.querySelector("children-jsons").innerHTML;
                        data = JSON.parse(data);
                        var tr = this.parentElement.parentElement;
                        var clss = _self.tree.getElementsByClassName("tree-parent-" + id);
                        //判断当前是否存在icon-plus
                        if (this.classList.contains("icon-plus")) {
                            level = parseInt(level) + 1;
                            _self.list_item(data, child, level, changes, tr);
                            this.classList.remove("icon-plus");
                            this.classList.add("icon-minus");
                            _self.tree_options_list();
                            _self.checkInput();
                        } else {
                            this.classList.add("icon-plus");
                            this.classList.remove("icon-minus");
                            _self.level_tops(id);

                        }
                    } else {
                        // var id = parseInt(this.parentElement.parentElement.getAttribute("data-level"));
                        var ul = (this.parentElement.querySelector("ul"));
                        if(this.classList.contains("icon-plus")){
                            this.classList.remove("icon-plus");
                            this.classList.add("icon-minus");
                            ul.classList.remove("ver-tree-levels-hide");
                        }else{
                            this.classList.add("icon-plus");
                            this.classList.remove("icon-minus");
                            ul.classList.add("ver-tree-levels-hide");
                        }
                    }
                }
            });
        },
        /*
         * 全选&反选
         */
        checkInput: function () {
            var inputs = this.tree.querySelectorAll(".ver-tree-checks"),
                _self = this;
            inputs.forEach(function (item) {
                item.onclick = function () {
                    if (_self.type == "list") {
                        var ins = _self.tree.querySelectorAll(".ver-tree-check"),
                            all = _self.tree.querySelector(".ver-tree-check-all");
                        //判断是否是选中状态；
                        if (this.classList.contains("icon-check-box-cicre")) {
                            this.classList.add("icon-check-box");
                            this.classList.remove("icon-check-box-cicre");
                            //判断是全选还是单选
                            if (this.classList.contains("ver-tree-check-all")) {
                                ins.forEach(function (it) {
                                    it.classList.add("icon-check-box");
                                    it.classList.remove("icon-check-box-cicre");
                                    it.parentElement.querySelector("input[type=checkbox]").checked = false;
                                });
                            } else {
                                this.parentElement.querySelector("input[type=checkbox]").checked = false;
                                all.classList.remove("icon-check-box-cicre");
                                all.classList.add("icon-check-box");

                            }
                        } else {
                            this.classList.remove("icon-check-box");
                            this.classList.add("icon-check-box-cicre");
                            //判断是全选还是单选
                            if (this.classList.contains("ver-tree-check-all")) {
                                ins.forEach(function (it) {
                                    it.classList.add("icon-check-box-cicre");
                                    it.classList.remove("icon-check-box");
                                    it.parentElement.querySelector("input[type=checkbox]").checked = true;
                                });
                            } else {
                                this.parentElement.querySelector("input[type=checkbox]").checked = true;

                                //判断是否全部选中
                                var name = this.parentElement.querySelector("input[type=checkbox]").name,
                                    check_len = _self.tree.querySelectorAll("input[name='" + name + "']:checked").length,
                                    length = ins.length;
                                if (check_len == length) {
                                    all.classList.remove("icon-check-box");
                                    all.classList.add("icon-check-box-cicre");
                                } else {
                                    all.classList.remove("icon-check-box-cicre");
                                    all.classList.add("icon-check-box");
                                }
                            }
                        }
                    } else if (_self.type == "form") {
                        var id = this.parentElement.parentElement.getAttribute("data-id"),
                            parent = this.parentElement.parentElement.getAttribute("data-parent"),
                            childrends = _self.tree.querySelectorAll(".tree-parent-" + id),
                            levels = parseInt(this.parentElement.parentElement.getAttribute("data-level")),
                            // tops = _self.tree.querySelectorAll(".ver-tree-level-0"),
                            p = _self.tree.querySelector("[data-id='" + parent + "']");
                        // l = 0;
                        //判断是否选中状态
                        if (this.classList.contains("icon-check-box-cicre")) {
                            this.classList.remove("icon-check-box-cicre");
                            this.classList.add("icon-check-box");
                            this.parentElement.querySelector("input[type=checkbox]").checked = false;
                            if (childrends.length > 0) {
                                childrends.forEach(function (items) {
                                    items.querySelectorAll(".ver-tree-checks").forEach(function (it) {
                                        it.classList.remove("icon-check-box-cicre");
                                        it.classList.add("icon-check-box");
                                        it.parentElement.querySelector("input[type=checkbox]").checked = false;
                                    });
                                })
                            }
                        } else {
                            this.classList.remove("icon-check-box");
                            this.classList.add("icon-check-box-cicre");
                            this.parentElement.querySelector("input[type=checkbox]").checked = true;
                            if (levels > 0) {
                                var ls = levels - 1;
                                _self.tops(ls, id);
                            }

                            if (childrends.length > 0) {
                                childrends.forEach(function (items) {
                                    items.querySelectorAll(".ver-tree-checks").forEach(function (it) {
                                        it.classList.remove("icon-check-box");
                                        it.classList.add("icon-check-box-cicre");
                                        it.parentElement.querySelector("input[type=checkbox]").checked = true;
                                    })
                                })
                            }
                        }
                    }
                }

            });
        },
        tops: function (levels, id) {
            var tops = document.querySelectorAll(".ver-tree-level-" + levels);

            if (tops.length > 0) {
                tops.forEach(function (item) {
                    if (item.querySelectorAll("[data-id='" + id + "']").length > 0) {
                        var icons = item.querySelector(".ver-tree-checks");
                        icons.classList.remove("icon-check-box");
                        icons.classList.add("icon-check-box-cicre");
                        icons.parentElement.querySelector("input[type=checkbox]").checkbox = true;
                    }
                });
                if (levels >= 0) {
                    this.tops((levels - 1), id);
                }
            } else {
                return false;
            }
        },
        level_tops:function (id) {
            var tops = document.querySelectorAll("[data-parent='"+id+"']");
            if(tops.length < 1) return false;
            for (var i = tops.length - 1; i >= 0; i--) {
                // cls
                var cl = tops[i],
                    ids = cl.getAttribute("data-id");
                cl.parentElement.removeChild(cl);
                this.level_tops(ids);
            }
        }
    };
    return tree;
})();


/*
 * Treeview 1.4.2 - jQuery plugin to hide and show branches of a tree
 *
 * http://bassistance.de/jquery-plugins/jquery-plugin-treeview/
 *
 * Copyright J枚rn Zaefferer
 * Released under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 */

;(function($) {

    // TODO rewrite as a widget, removing all the extra plugins
    $.extend($.fn, {
        swapClass: function(c1, c2) {
            var c1Elements = this.filter('.' + c1);
            this.filter('.' + c2).removeClass(c2).addClass(c1);
            c1Elements.removeClass(c1).addClass(c2);
            return this;
        },
        replaceClass: function(c1, c2) {
            return this.filter('.' + c1).removeClass(c1).addClass(c2).end();
        },
        hoverClass: function(className) {
            className = className || "hover";
            return this.hover(function() {
                $(this).addClass(className);
            }, function() {
                $(this).removeClass(className);
            });
        },
        heightToggle: function(animated, callback) {
            animated ?
                this.animate({ height: "toggle" }, animated, callback) :
                this.each(function(){
                    jQuery(this)[ jQuery(this).is(":hidden") ? "show" : "hide" ]();
                    if(callback)
                        callback.apply(this, arguments);
                });
        },
        heightHide: function(animated, callback) {
            if (animated) {
                this.animate({ height: "hide" }, animated, callback);
            } else {
                this.hide();
                if (callback)
                    this.each(callback);
            }
        },
        prepareBranches: function(settings) {
            if (!settings.prerendered) {
                // mark last tree items
                this.filter(":last-child:not(ul)").addClass(CLASSES.last);
                // collapse whole tree, or only those marked as closed, anyway except those marked as open
                this.filter((settings.collapsed ? "" : "." + CLASSES.closed) + ":not(." + CLASSES.open + ")").find(">ul").hide();
            }
            // return all items with sublists
            return this.filter(":has(>ul)");
        },
        applyClasses: function(settings, toggler) {
            // TODO use event delegation
            this.filter(":has(>ul):not(:has(>a))").find(">span").unbind("click.treeview").bind("click.treeview", function(event) {
                // don't handle click events on children, eg. checkboxes
                if ( this == event.target )
                    toggler.apply($(this).next());
            }).add( $("a", this) ).hoverClass();

            if (!settings.prerendered) {
                // handle closed ones first
                this.filter(":has(>ul:hidden)")
                    .addClass(CLASSES.expandable)
                    .replaceClass(CLASSES.last, CLASSES.lastExpandable);

                // handle open ones
                this.not(":has(>ul:hidden)")
                    .addClass(CLASSES.collapsable)
                    .replaceClass(CLASSES.last, CLASSES.lastCollapsable);

                // create hitarea if not present
                var hitarea = this.find("div." + CLASSES.hitarea);
                if (!hitarea.length)
                    hitarea = this.prepend("<div class=\"" + CLASSES.hitarea + "\"/>").find("div." + CLASSES.hitarea);
                hitarea.removeClass().addClass(CLASSES.hitarea).each(function() {
                    var classes = "";
                    $.each($(this).parent().attr("class").split(" "), function() {
                        classes += this + "-hitarea ";
                    });
                    $(this).addClass( classes );
                })
            }

            // apply event to hitarea
            this.find("div." + CLASSES.hitarea).click( toggler );
        },
        treeview: function(settings) {

            settings = $.extend({
                cookieId: "treeview"
            }, settings);

            if ( settings.toggle ) {
                var callback = settings.toggle;
                settings.toggle = function() {
                    return callback.apply($(this).parent()[0], arguments);
                };
            }

            // factory for treecontroller
            function treeController(tree, control) {
                // factory for click handlers
                function handler(filter) {
                    return function() {
                        // reuse toggle event handler, applying the elements to toggle
                        // start searching for all hitareas
                        toggler.apply( $("div." + CLASSES.hitarea, tree).filter(function() {
                            // for plain toggle, no filter is provided, otherwise we need to check the parent element
                            return filter ? $(this).parent("." + filter).length : true;
                        }) );
                        return false;
                    };
                }
                // click on first element to collapse tree
                $("a:eq(0)", control).click( handler(CLASSES.collapsable) );
                // click on second to expand tree
                $("a:eq(1)", control).click( handler(CLASSES.expandable) );
                // click on third to toggle tree
                $("a:eq(2)", control).click( handler() );
            }

            // handle toggle event
            function toggler() {
                $(this)
                    .parent()
                    // swap classes for hitarea
                    .find(">.hitarea")
                    .swapClass( CLASSES.collapsableHitarea, CLASSES.expandableHitarea )
                    .swapClass( CLASSES.lastCollapsableHitarea, CLASSES.lastExpandableHitarea )
                    .end()
                    // swap classes for parent li
                    .swapClass( CLASSES.collapsable, CLASSES.expandable )
                    .swapClass( CLASSES.lastCollapsable, CLASSES.lastExpandable )
                    // find child lists
                    .find( ">ul" )
                    // toggle them
                    .heightToggle( settings.animated, settings.toggle );
                if ( settings.unique ) {
                    $(this).parent()
                        .siblings()
                        // swap classes for hitarea
                        .find(">.hitarea")
                        .replaceClass( CLASSES.collapsableHitarea, CLASSES.expandableHitarea )
                        .replaceClass( CLASSES.lastCollapsableHitarea, CLASSES.lastExpandableHitarea )
                        .end()
                        .replaceClass( CLASSES.collapsable, CLASSES.expandable )
                        .replaceClass( CLASSES.lastCollapsable, CLASSES.lastExpandable )
                        .find( ">ul" )
                        .heightHide( settings.animated, settings.toggle );
                }
            }
            this.data("toggler", toggler);

            function serialize() {
                function binary(arg) {
                    return arg ? 1 : 0;
                }
                var data = [];
                branches.each(function(i, e) {
                    data[i] = $(e).is(":has(>ul:visible)") ? 1 : 0;
                });
                $.cookie(settings.cookieId, data.join(""), settings.cookieOptions );
            }

            function deserialize() {
                var stored = $.cookie(settings.cookieId);
                if ( stored ) {
                    var data = stored.split("");
                    branches.each(function(i, e) {
                        $(e).find(">ul")[ parseInt(data[i]) ? "show" : "hide" ]();
                    });
                }
            }

            // add treeview class to activate styles
            this.addClass("treeview");

            // prepare branches and find all tree items with child lists
            var branches = this.find("li").prepareBranches(settings);

            switch(settings.persist) {
                case "cookie":
                    var toggleCallback = settings.toggle;
                    settings.toggle = function() {
                        serialize();
                        if (toggleCallback) {
                            toggleCallback.apply(this, arguments);
                        }
                    };
                    deserialize();
                    break;
                case "location":
                    var current = this.find("a").filter(function() {
                        return location.href.toLowerCase().indexOf(this.href.toLowerCase()) == 0;
                    });
                    if ( current.length ) {
                        // TODO update the open/closed classes
                        var items = current.addClass("selected").parents("ul, li").add( current.next() ).show();
                        if (settings.prerendered) {
                            // if prerendered is on, replicate the basic class swapping
                            items.filter("li")
                                .swapClass( CLASSES.collapsable, CLASSES.expandable )
                                .swapClass( CLASSES.lastCollapsable, CLASSES.lastExpandable )
                                .find(">.hitarea")
                                .swapClass( CLASSES.collapsableHitarea, CLASSES.expandableHitarea )
                                .swapClass( CLASSES.lastCollapsableHitarea, CLASSES.lastExpandableHitarea );
                        }
                    }
                    break;
            }

            branches.applyClasses(settings, toggler);

            // if control option is set, create the treecontroller and show it
            if ( settings.control ) {
                treeController(this, settings.control);
                $(settings.control).show();
            }

            return this;
        }
    });

    // classes used by the plugin
    // need to be styled via external stylesheet, see first example
    $.treeview = {};
    var CLASSES = ($.treeview.classes = {
        open: "open",
        closed: "closed",
        expandable: "expandable",
        expandableHitarea: "expandable-hitarea",
        lastExpandableHitarea: "lastExpandable-hitarea",
        collapsable: "collapsable",
        collapsableHitarea: "collapsable-hitarea",
        lastCollapsableHitarea: "lastCollapsable-hitarea",
        lastCollapsable: "lastCollapsable",
        lastExpandable: "lastExpandable",
        last: "last",
        hitarea: "hitarea"
    });

})(jQuery);