const assert = require('assert');
const Account = require('../account.js');
const Bank = require('../bank.js');

describe ('Bank', function(){
  let bank;
  let account1, account2, account3, account4;

  beforeEach(function() {
    bank = new Bank("RBS")
    account1 = new Account("Fraser Brown", "Personal");
    account2 = new Account("Jardine Miller", "Personal");  
    account3 = new Account("Ian Henderson", "Business");
    account4 = new Account("Matthew Manson", "Childrens");
  })

  it('has bank name when created', function(){
    assert.strictEqual(bank.name, "RBS");
  })

  it('can add account', function() {
    bank.addAccount(account1);
    assert.strictEqual(1, bank.accounts.length);
  })

  it('holder can add money to account', function(){
    bank.addAccount(account1);
    bank.deposit(account1, 200);
    assert.strictEqual(bank.accounts[0].value, 200);
  }) 

  it('can find largest account by value', function(){
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);
    bank.addAccount(account4);
    bank.deposit(account1, 200);
    bank.deposit(account2, 300);
    bank.deposit(account3, 100);
    bank.deposit(account4, 150);
    assert.strictEqual(bank.findLargestAcc(), account2);
  })


  it('can find average total of accounts', function() {
    bank.addAccount(account1);
    bank.addAccount(account4);
    bank.deposit(account1, 75);
    bank.deposit(account4, 25);
    assert.strictEqual(bank.findAverageValue(), 50);
  })

  it('can find total', function(){
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);
    bank.addAccount(account4);
    bank.deposit(account1, 200);
    bank.deposit(account2, 300);
    bank.deposit(account3, 100);
    bank.deposit(account4, 150);
    assert.strictEqual(bank.findTotal(), 750);
  })

  it('can find by type', function() {
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);
    bank.addAccount(account4);
    bank.deposit(account1, 200);
    bank.deposit(account2, 300);
    bank.deposit(account3, 100);
    bank.deposit(account4, 150);
    assert.strictEqual(bank.findByType("Personal").length, 2);
  })

  it('can find total value of account',function() {
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.addAccount(account3);
    bank.addAccount(account4);
    bank.deposit(account1, 200);
    bank.deposit(account2, 300);
    bank.deposit(account3, 100);
    bank.deposit(account4, 150);
    assert.strictEqual(bank.findTotalValueOfType("Personal"), 500);
  }) 

  it('can find by owner name', function() {
    bank.addAccount(account1);
    bank.addAccount(account2);
    bank.deposit(account1, 200);
    bank.deposit(account2, 300);
    assert.strictEqual(bank.findByOwnerName("Jardine Miller"), account2);
  })

})