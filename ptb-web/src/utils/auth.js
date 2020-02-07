import Cookies from 'js-cookie'

const TokenKey = 'userLoginToken'
const UserId = 'loginUserId'
const MerchantUserId = 'loginMerchantUserId'
const Icon = 'loginIcon'


export function getToken() {
  return Cookies.get(TokenKey)
}

export function setToken(token) {
  return Cookies.set(TokenKey, token)
}

export function removeToken() {
  return Cookies.remove(TokenKey)
}

export function getUserId() {
  return Cookies.get(UserId)
}

export function getMerchantUserId() {
  return Cookies.get(MerchantUserId)
}

export function setMerchantUserId(Id) {
  return Cookies.set(MerchantUserId, Id)
}

export function setUserId(Id) {
  return Cookies.set(UserId, Id)
}

export function removeUserId() {
  return Cookies.remove(UserId)
}


export function getIcon() {
  return Cookies.get(Icon)
}

export function setIcon(Id) {
  return Cookies.set(Icon, Id)
}
