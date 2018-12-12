import request from '@/utils/request'

export default {
  getCityList() {
    return request({
      url: '/base/city',
      method: 'get'
    })
  }
}
