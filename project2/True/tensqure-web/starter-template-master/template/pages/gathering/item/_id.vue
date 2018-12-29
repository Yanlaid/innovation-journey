<template>
  <div>
    活动详情
    {{item.id}}
    <hr>
    {{item.name}}
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: "_id.vue",
    asyncData({params}) {
      return axios.get(`https://www.easy-mock.com/mock/5c0fb35284df40532d62bfab/api/gathering/${params.id}`)
        .then(
          resp => {
            return {
              item: resp.data.data
            }
          }
        )
    }
  }
</script>

<style scoped>

</style>
