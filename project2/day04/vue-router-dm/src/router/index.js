import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import list from '@/components/list'
import about from '@/components/about'
import item from '@/components/item'
import address from '@/components/address'
import linkman from '@/components/linkman'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/list',
      name: 'list',
      component: list
    },
    {
      path: '/about',
      name: 'about',
      component: about,
      children: [
        {path: 'address', component: address},
        {path: 'linkman', component: linkman}
      ]
    },
    {
      path: '/item/:type/:id',
      name: 'item',
      component: item
    }
  ]
})
