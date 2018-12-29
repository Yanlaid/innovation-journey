<template>
    <div>
      动态路由传递的消息1 {{$route.params.type}} <br>
      动态路由传递的消息2 {{$route.params.id}}
    </div>
</template>

<script>
    export default {
        name: "item"
    }
</script>

<style scoped>

</style>
