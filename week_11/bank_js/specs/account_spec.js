const assert = require('assert');
const Account = require('../account.js');

describe('Account', function() {

  let account;

  beforeEach(function() {
    account = new Account("Fraser Brown", "Personal");
  })

  it('has owner name when created', function() {
    assert.strictEqual(account.ownerName, "Fraser Brown");
  })

  it('has account type when created', function(){
    assert.strictEqual(account.type, "Personal");
  })

})