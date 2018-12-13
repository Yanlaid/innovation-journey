<template>
  <div>
    <h1>关于我们</h1>
    <router-link to="/about/address">地址</router-link>
    <router-link to="/about/linkman">联系人</router-link>
    <router-view/>
  </div>
</template>

<script>
  export default {
    name: 'about'
  }
</script>

<style scoped>

</style>
