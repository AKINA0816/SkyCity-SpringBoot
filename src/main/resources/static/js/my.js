// 注册 modal
$(function() {
    $('#register').bootstrapValidator({
        excluded: [':disabled', ':hidden', ':not(:visible)'],//默认指定不验证的情况
        message : 'This value is not valid',
        fields : {
            name: {  /*键名name和input name值对应*/
                message: '用户名不能为空',
                validators: {
                    notEmpty: { /*非空提示*/
                        message: '用户名必填不能为空'
                    },
                    stringLength: { /*长度提示*/
                        min: 6,
                        max: 30,
                        message: '用户名长度不能小于6位或超过30位'
                    },
                    regexp: { /*正则校验*/
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名只能由字母、数字、点和下划线组成。'
                    },
                    threshold: 6,//有6字符以上才发送ajax请求

                    remote: { //ajax验证。server result:{"valid",true or false} （返回前台类型）
                        url: "/findByName",
                        message: '用户名已存在,请重新输入',
                        delay: 500, //ajax刷新的时间是0.8秒一次
                        type: 'POST',
                    },


                }
            },
            password: {
                message:'密码无效',
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '密码长度必须在6到30之间'
                    },
                    identical:{
                        field: 'password',
                        message: '密码不匹配'
                    }

                }
            },
            password2: {
                message: '密码无效',
                validators: {
                    notEmpty:{
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'password',
                        message: '密码不匹配'
                    }

                }
            }

        }
    });
    //提交按钮,所有验证通过方可提交
    $("#registerButton").click(
        function() {
            var flag = $('#register').bootstrapValidator(
                'validate').data('bootstrapValidator').isValid();
            if (flag) {
                // pass
            }
        });
});

$('#personalInfo').modal({
    backdrop: false,
    show : false,
    keyboard: true
});

// chatbox scroll bar
$(document).ready(function () {
    if (!$.browser.webkit) {
        $('.wrapper').html('<p>Sorry! Non webkit users. :(</p>');
    }
});
// login modal
// $(function() {
//     $('#login').bootstrapValidator({
//         excluded: [':disabled', ':hidden', ':not(:visible)'],//默认指定不验证的情况
//         message : 'This value is not valid',
//         fields : {
//             name: {  /*键名name和input name值对应*/
//                 message: '用户名不能为空',
//                 validators: {
//                     notEmpty: { /*非空提示*/
//                         message: '用户名必填不能为空'
//                     },
//                 }
//             },
//             password: {
//                 message:'密码无效',
//                 validators: {
//                     notEmpty: {
//                         message: '密码不能为空'
//                     },
//                 }
//             },
//         }
//     });
//     //提交按钮,所有验证通过方可提交
//     $("#loginButton").click(
//         function() {
//             var flag = $('#login').bootstrapValidator(
//                 'validate').data('bootstrapValidator').isValid();
//             if (flag) {
//                 // pass
//             }
//         });
// });

