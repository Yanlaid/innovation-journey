    import Vue from '../node_modules/vue/dist/vue'
    /*TODO 注意vue-router的引入顺序，在vue.js后*/
    import VueRouter from '../node_modules/vue-router/dist/vue-router'
    import loginForm from './js/login'
    import registerForm from './js/register'
    /*TODO 引入外部CSS文件*/
    import './css/main.css'


    /*TODO
        js模块中若使用到vuerouter，需要额外声明
    * */
    Vue.use(VueRouter);

    let router = new VueRouter({
    routes: [ /*TODO 多个路由规则*/
        {
            path: '/login', /*TODO 请求路径*/
            component: loginForm /*TODO 组件名称*/
        }, {
            path: '/register',
            component: registerForm
        }
    ]
});
let app = new Vue({
    el: '#app',
    components: {loginForm, registerForm},
    /*TODO 将vue-router实例添加到vue中*/
    router
});

