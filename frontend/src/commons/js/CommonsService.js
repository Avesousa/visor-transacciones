'use strict'

class CommonsService {

  static _instance;

  constructor() {
    this.authHeader = {
      'PORTAL_TOKEN': null
    }
  }

  static instance(){
    if ( this._instance == null ){
      this._instance = new CommonsService();
    }
    return this._instance;
  }

  set(p = {}) {
//    _.each(p, (value, key) => {
//      this[key] = value;
//    });
    if (p.token){
      this.registerToken(p.token)
    }
  }

  registerToken(key) {
    console.log("registering token: " + key);
    this.authHeader['PORTAL_TOKEN'] = key;
  }

  getAuthHeader(){
    return this.authHeader;
  }

  getAuthHeaderKeyValue(){
    return {
      key: 'PORTAL_TOKEN',
      value: this.authHeader['PORTAL_TOKEN']
    }
  }
}

export default CommonsService
