import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);
const store = new Vuex.Store(  {
  state: {
    count: 0
  },
  mutations: {
    increment(state, x) {
      state.count += x;
    }
  },
  actions:{
    increment(context){
      context.commit('increment',10)
    }
  },
  getters:{
    remark(state){
      if (state.count<50){
        return '加油'
      }  else if(state.count<100){
        return '你真棒'
      }else{
        return 'else执行'
      }

    }
  }
});
export default store;
