const Account = function(name, accountType){
  this.ownerName = name;
  this.type = accountType;
  this.value = 0;
}

Account.prototype.increaseFunds = function(amount) {
  this.value += amount;
};

module.exports = Account;

