/**
 * Service class to extract the functionality of list and getting users.
 */
export default {

  list() {
    return fetch('https://jsonplaceholder.typicode.com/users')
    .then((response) => {
      return response.json();
    });
  },

  get(userId) {
    return fetch(`https://jsonplaceholder.typicode.com/users/${userId}`)
    .then((response) => {
      return response.json();
    });
  }

}
