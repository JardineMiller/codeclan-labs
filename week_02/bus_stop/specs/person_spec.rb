require('minitest/autorun')
require('minitest/rg')
require_relative('../bus.rb')
require_relative('../person.rb')
require_relative('../bus_stop.rb')

class TestPerson < MiniTest::Test
	def setup
		@person = Person.new("Fraser", 22)
	end

	def test_person_name
		assert_equal("Fraser", @person.name)
	end
	def test_person_age
		assert_equal(22, @person.age)
	end

end