import request from '@/utils/request'

const group_name = 'gathering'
const api_name = 'api'
export default {

//  查询活动列表
  getList() {
    return request({
      url: '/${api_name}/${group_name}',
      method: 'get'
    })
  },
  /*page:第几页
    size：当前页数
    searchMap:查询条件
  * */
  getPageList(page, size, searchMap) {
    return request({
      url: `/${api_name}/${group_name}/search/${page}/${size}`,
      method: 'post',
      data: searchMap
    })
  },
  save(pojo) {
    return request({
      url: '/${api_name}/${group_name}',
      method: 'post',
      data: pojo
    })
  },
  findById(id) {
    return request({
      url: `/${api_name}/${group_name}/${id}`,
      method: 'get'
    })
  },
  updatePojo(id, pojo) {
    return request({
      url: `${api_name}/${group_name}/${id}`,
      method: 'put',
      data: pojo
    })
  },
  deletePojoById(id) {
    return request({
      url: `${api_name}/${group_name}/${id}`,
      method: 'delete'
    })
  }

}

