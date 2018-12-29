import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);
// noinspection JSValidateTypes
const store = new Vuex.Store({
  state: {
    count: 8888,
    nickName:'沈'
  }
});
export default store;
