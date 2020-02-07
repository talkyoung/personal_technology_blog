import service from './request'
export const getUserRolePermission = (userId) => {
  return service({
    url: '/userRole/getUserRolePermission/' + userId,
    method: 'get'
  })
};

export const hello = () => {
  return service({
    url: '/hello',
    method: 'get'
  })
};

export const login = data => {
  return service({
    url: '/login',
    method: 'post',
    data: data
  })
};
