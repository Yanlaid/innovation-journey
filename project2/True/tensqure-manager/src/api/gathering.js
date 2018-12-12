import request from '@/utils/request'

export default {

//  查询活动列表
  getList() {
    return request({
      url: '/api/gathering',
      method: 'get'
    })
  },
  /*page:第几页
    size：当前页数
    searchMap:查询条件
  * */
  getPageList(page, size, searchMap) {
    return request({
      url: `/api/gathering/search/${page}/${size}`,
      method: 'post',
      data: searchMap
    })
  },
  save(pojo) {
    return request({
      url: '/api/gathering',
      method: 'post',
      data: pojo
    })
  },
  findById(id) {
    return request({
      url: `/api/gathering/${id}`,
      method: 'get'
    })
  },
  updatePojo(id, pojo) {
    return request({
      url: `api/gathering/${id}`,
      method: 'put',
      data: pojo
    })
  }

}

