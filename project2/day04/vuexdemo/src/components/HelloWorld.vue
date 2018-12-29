<template>
  <div>
    {{$store.state.count}}<br>
    {{$store.getters.remark}}
    <button @click="showCount">点击</button>
    <button @click="add">增加</button>
  </div>
</template>

<script>
export default {
  methods:{
    showCount(){
      console.log(this.$store.state.count)
    },
    add(){
      this.$store.dispatch('increment',20);
    }
  }
}
</script>

