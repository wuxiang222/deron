<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<script type="text/javascript">
    //判断类型type，special-->image,voice-->audio
    function judgeUrl(parameters) {
        var val = parameters.val;
        var row = parameters.row;
        var index = parameters.index;
        if (row.type == "special") {
            return "<img width='70' height='70' src='" + row.url + "'/>";
        } else {
            return "<audio src='" + row.url + "' controls></audio>";
        }
    }
    //自定义 操作列
    function operations1(parameters) {
        var val = parameters.val;
        var row = parameters.row;
        var index = parameters.index;
        return "<a href='javascript:void(0)' class='edit' onclick='editSV(\"" + row.id + "\",\"" + row.type +
            "\")'>编辑</a> | <a href='javascript:void(0)' class='drop' onclick='dropSV(\"" + row.id + "\",\"" + row.type + "\")'>删除</a>";
    }
    //给删除和修改添加easyui-linkbutton
    function addCss() {
        $("a.edit").linkbutton({
            plain: true,
            iconCls: "icon-edit",
            height: 18
        });
        $("a.drop").linkbutton({
            plain: true,
            iconCls: "icon-remove",
            height: 18
        });
    }
    var id;
    //修改
    function editSV(pid, type) {
        console.log(pid);
        console.log(type);
        id = pid;
        if (type === "special") {
            $("#modifySpecialDialog").dialog("open");
        }
        if (type === "voice") {
            $("#modifyVoiceDialog").dialog("open");
        }
    }
    //删除
    function dropSV(id, type) {
        console.log(type);
        if (type === "special") {
            $.get(
                "${pageContext.request.contextPath}/special/del",
                "id=" + id,
                function (reslut) {
                    $.messager.show({
                        title: "系统提示 ",
                        msg: "删除专辑成功!"
                    });
                    $("#specialTreegrid").treegrid("load");
                }
            );
        } else if (type === "voice") {
            $.get(
                "${pageContext.request.contextPath}/voice/del",
                "id=" + id,
                function (reslut) {
                    $.messager.show({
                        title: "系统提示 ",
                        msg: "删除音频成功!"
                    });
                    $("#specialTreegrid").treegrid("load");
                }
            );
        } else {

        }
    }

    $(function () {
        //初始化treegridtreegrid
        $("#specialTreegrid").treegrid({
            url: "${pageContext.request.contextPath}/special/queryByPage",
            fitColumns: true,
            pagination: true,
            height: "100%",
            pageSize: 5,
            pageList: [5, 10, 15, 30, 50, 100],
            rownumbers: true,
            onLoadSuccess: addCss,
            idField: "id",
            treeField: "name",
            toolbar: "#specialBtn",
        });
        //初始化添加专辑按钮添加专辑的linkbutton
        $("#addSpecialBtn").linkbutton({
            iconCls: "icon-add",
            onClick: function () {
                $("#addSpecialDialog").dialog("open");
            }
        });
        //初始化添加专辑对话框添加专辑dialog
        $("#addSpecialDialog").dialog({
            width: 400,
            height: 300,
            title: "添加专辑文件",
            closed: true,
            collapsible: true,//可折叠
            minimizable: true,//可最小化按钮
            maximizable: true,//可最大化按钮
            resizable: true,//可改变对话框窗口大小
            modal: true,
            cache: false,
            href: "${pageContext.request.contextPath}/back/page/specialAddDialogForm.jsp",
            buttons: "#addSpecialDialogBtn"
        });
        //初始化添加专辑对话框中的保存按钮添加专辑对话框保存linkbutton
        $("#addSpecialSaveBtn").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $("#addSpecialForm").form("submit", {
                    url: "${pageContext.request.contextPath}/special/add",
                    onSubmit: function () {
                        return $("#addSpecialForm").form("validate");
                    },
                    success: function () {
                        //成功后弹出提示框并刷新表格的当前页
                        $.messager.show({
                            title: "系统提示 ",
                            msg: "保存成功!"
                        });
                        $("#addSpecialDialog").dialog("close");
                        $("#specialTreegrid").treegrid("load");
                    }
                });
            }
        });
        //初始化添加专辑对话框中的取消按钮添加专辑对话框取消linkbutton
        $("#addSpecialQuitBtn").linkbutton({
            iconCls: "icon-back",
            onClick: function () {
                $("#addSpecialDialog").dialog("close");
            }
        });
        //修改相关

        //初始化修改专辑对话框修改专辑dialog
        $("#modifySpecialDialog").dialog({
            width: 400,
            height: 300,
            title: "添加专辑文件",
            closed: true,
            collapsible: true,//可折叠
            minimizable: true,//可最小化按钮
            maximizable: true,//可最大化按钮
            resizable: true,//可改变对话框窗口大小
            modal: true,
            cache: false,
            href: "${pageContext.request.contextPath}/back/page/specialEditDialogForm.jsp",
            buttons: "#modifySpecialDialogBtn"
        });
        //初始化修改专辑对话框中的保存按钮修改专辑对话框保存linkbutton
        $("#modifySpecialSaveBtn").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $("#modifySpecialForm").form("submit", {
                    url: "${pageContext.request.contextPath}/special/change",
                    onSubmit: function () {
                        return $("#modifySpecialForm").form("validate");
                    },
                    success: function () {
                        //成功后弹出提示框并刷新表格的当前页
                        $.messager.show({
                            title: "系统提示 ",
                            msg: "保存成功!"
                        });
                        $("#modifySpecialDialog").dialog("close");
                        $("#specialTreegrid").treegrid("reload");
                    }
                });
            }
        });
        //初始化修改专辑对话框中的取消按钮修改专辑对话框取消linkbutton
        $("#modifySpecialQuitBtn").linkbutton({
            iconCls: "icon-back",
            onClick: function () {
                $("#modifySpecialDialog").dialog("close");
            }
        });
        //音频相关


        //初始化添加音频按钮添加音频的linkbutton
        $("#addVoiceBtn").linkbutton({
            iconCls: "icon-add",
            onClick: function () {
                var data = $("#specialTreegrid").treegrid("getSelected");
                console.log(data);
                if (null === data || data.type === "voice") {
                    alert("请先选择所属专辑");
                } else if (data.type === "special") {
                    //初始化添加音频对话框添加音频dialog
                    $("#addVoiceDialog").dialog({
                        width: 400,
                        height: 300,
                        title: "添加音频文件",
                        closed: false,
                        collapsible: true,//可折叠
                        minimizable: true,//可最小化按钮
                        maximizable: true,//可最大化按钮
                        resizable: true,//可改变对话框窗口大小
                        modal: true,
                        cache: false,
                        href: "${pageContext.request.contextPath}/back/page/voiceAddDialogForm.jsp?specialID=" + data.id + "&name=" + data.name,
                        buttons: "#addVoiceDialogBtn"
                    });
                }

            }
        });

        //初始化添加音频对话框中的保存按钮添加音频对话框保存linkbutton
        $("#addVoiceSaveBtn").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $("#addVoiceForm").form("submit", {
                    url: "${pageContext.request.contextPath}/voice/add",
                    onSubmit: function () {
                        return $("#addVoiceForm").form("validate");
                    },
                    success: function () {
                        //成功后弹出提示框并刷新表格的当前页
                        $.messager.show({
                            title: "系统提示 ",
                            msg: "保存成功!"
                        });
                        $("#addVoiceDialog").dialog("close");
                        $("#specialTreegrid").treegrid("load");
                    }
                });
            }
        });
        //初始化添加音频对话框中的取消按钮添加音频对话框取消linkbutton
        $("#addVoiceQuitBtn").linkbutton({
            iconCls: "icon-back",
            onClick: function () {
                $("#addVoiceDialog").dialog("close");

            }
        });
        //修改音频
        //初始化修改专辑对话框修改专辑dialog
        $("#modifyVoiceDialog").dialog({
            width: 400,
            height: 300,
            title: "修改音频文件",
            closed: true,
            collapsible: true,//可折叠
            minimizable: true,//可最小化按钮
            maximizable: true,//可最大化按钮
            resizable: true,//可改变对话框窗口大小
            modal: true,
            cache: false,
            href: "${pageContext.request.contextPath}/back/page/voiceEditDialogForm.jsp",
            buttons: "#modifyVoiceDialogBtn"
        });
        //初始化修改专辑对话框中的保存按钮修改专辑对话框保存linkbutton
        $("#modifyVoiceSaveBtn").linkbutton({
            iconCls: "icon-save",
            onClick: function () {
                $("#modifyVoiceForm").form("submit", {
                    url: "${pageContext.request.contextPath}/voice/change",
                    onSubmit: function () {
                        return $("#modifyVoiceForm").form("validate");
                    },
                    success: function () {
                        //成功后弹出提示框并刷新表格的当前页
                        $.messager.show({
                            title: "系统提示 ",
                            msg: "保存成功!"
                        });
                        $("#modifyVoiceDialog").dialog("close");
                        $("#specialTreegrid").treegrid("reload");
                    }
                });
            }
        });
        //初始化修改专辑对话框中的取消按钮修改专辑对话框取消linkbutton
        $("#modifyVoiceQuitBtn").linkbutton({
            iconCls: "icon-back",
            onClick: function () {
                $("#modifyVoiceDialog").dialog("close");
            }
        });
    });

</script>
<table id="specialTreegrid" class="easyui-treegrid">
    <thead>
    <tr>
        <th data-options="field:'id',width:80" hidden></th>
        <th data-options="field:'8888',checkbox:true" hidden></th>
        <th data-options="field:'name',width:80">专辑名称</th>
        <th data-options="field:'url',width:180,formatter:judgeUrl">url</th>
        <th data-options="field:'author',width:50">作者</th>
        <th data-options="field:'broadcast',width:50">播音员</th>
        <th data-options="field:'content',width:80">简介</th>
        <th data-options="field:'type',width:30">type</th>
        <th data-options="field:'publish',width:80">创建时间</th>
        <th data-options="field:'xxxx',width:80,formatter:operations1">操作</th>
    </tr>
    </thead>
</table>
<!-- 表格上方的工具栏 -->
<div id="specialBtn">
    <a href="javascript:void(0)" id="addSpecialBtn">添加专辑</a>
    <a href="javascript:void(0)" id="addVoiceBtn">添加音频</a>
</div>
<!-- 添加专辑界面的界面 -->
<div id="addSpecialDialog"></div>
<!-- 添加专辑界面的按钮 -->
<div id="addSpecialDialogBtn">
    <a id="addSpecialSaveBtn">保存</a>
    <a id="addSpecialQuitBtn">取消</a>
</div>
<!-- 添加音频界面的界面 -->
<div id="addVoiceDialog"></div>
<!-- 添加专辑界面的按钮 -->
<div id="addVoiceDialogBtn">
    <a id="addVoiceSaveBtn">保存</a>
    <a id="addVoiceQuitBtn">取消</a>
</div>
<!-- 修改专辑的dialog -->
<div id="modifySpecialDialog"></div>
<!-- 修改专辑界面的按钮 -->
<div id="modifySpecialDialogBtn">
    <a id="modifySpecialSaveBtn">修改</a>
    <a id="modifySpecialQuitBtn">取消</a>
</div>
<!-- 修改专辑的dialog -->
<div id="modifyVoiceDialog"></div>
<!-- 修改专辑界面的按钮 -->
<div id="modifyVoiceDialogBtn">
    <a id="modifyVoiceSaveBtn">修改</a>
    <a id="modifyVoiceQuitBtn">取消</a>
</div>
