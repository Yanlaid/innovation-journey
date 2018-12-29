<template>
  <div>
    {{$store.state.count}}
    <br>
    {{$store.state.nickName}}
    <button @click="showCount">点击</button>
    <button @click="addCount">增加</button>
  </div>
</template>
<script>
  export default {
    methods:{
      showCount(){
        console.log(this.$store.state.count);
      },
      addCount(){
        this.$.store.commit('increment')
      }
    }
  }
</script>
