// Frontend config used by all static pages
(function () {
  var defaultApi = 'http://localhost:8081/api'; // warehost service

  window.WAREHOST_CONFIG = {
    API_BASE: defaultApi,
    get PRODUCTS() { return this.API_BASE + '/products'; },
    get RECOMMENDATIONS() { return this.API_BASE + '/recommendations'; },
    get REORDERS() { return this.API_BASE + '/inventory/reorders'; }
  };

  window.apiFetch = function (path, opts) {
    var url = path && path.indexOf('http') === 0 ? path : (window.WAREHOST_CONFIG.API_BASE + path);
    return fetch(url, opts);
  };
})();
