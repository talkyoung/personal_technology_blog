const getters = {
  token: state => state.user.token,
  userId: state => state.user.userId,
  isLoadRoutes: state => state.user.isLoadRoutes,
  permissions: state => state.user.permissions,
};
export default getters
