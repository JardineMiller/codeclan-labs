const Bank = function(name) {
  this.name = name;
  this.accounts = [];
}

Bank.prototype.addAccount = function(account) {
  this.accounts.push(account);
};

Bank.prototype.deposit = function(account, amount) {
  account.increaseFunds(amount);
};

Bank.prototype.findLargestAcc = function() {
  var largest = this.accounts[0];
  for(account of this.accounts){
    if (account.value > largest.value){
      largest = account;
    }
  }
  return largest;
};

Bank.prototype.findAverageValue = function() {
  return this.findTotal() / this.accounts.length;
};

Bank.prototype.findTotal = function() {
  var total = 0;
  for(account of this.accounts){
    total += account.value;
  }
  return total;
};

Bank.prototype.findByType = function(type) {
  let filteredAccounts = [];
  for(account of this.accounts) {
    if(account.type === type) {
      filteredAccounts.push(account);
    }
  }
  return filteredAccounts;
};

Bank.prototype.findTotalValueOfType = function(type) {
  let filtered = this.findByType(type);
  let total = 0;
  for(account of filtered) {
    total += account.value;
  }
  return total;
};

Bank.prototype.findByOwnerName = function(name) {
  for(account of this.accounts) {
    if(account.ownerName === name) {
      return account;
    }
  }
};

module.exports = Bank;