'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  /*todo 修改了接口网址*/
  // BASE_API: '"https://easy-mock.com/mock/5950a2419adc231f356a6636/vue-admin"',
  BASE_API: '" https://www.easy-mock.com/mock/5c0fb35284df40532d62bfab"',
})
