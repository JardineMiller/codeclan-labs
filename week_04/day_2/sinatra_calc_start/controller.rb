require ('sinatra')
require ('sinatra/reloader')
require_relative('models/calculator.rb')

get '/add/:num1/:num2' do
  num1 = params[:num1].to_i
  num2 = params[:num2].to_i
  calc = Calculator.new(num1, num2)
  @calculation = calc.add.to_s
  erb :result
end

get '/subtract/:num1/:num2' do
  num1 = params[:num1].to_i
  num2 = params[:num2].to_i
  calc = Calculator.new(num1, num2)
  @calculation = calc.subtract.to_s
  erb :result
end

get '/multiply/:num1/:num2' do
  num1 = params[:num1].to_i
  num2 = params[:num2].to_i
  calc = Calculator.new(num1, num2)
  @calculation = calc.multiply.to_s
  erb :result
end

get '/divide/:num1/:num2' do
  num1 = params[:num1].to_f
  num2 = params[:num2].to_f
  calc = Calculator.new(num1, num2)
  @calculation = calc.divide.to_s
  erb :result
end

get '/power/:num1/:num2' do
  num1 = params[:num1].to_i
  num2 = params[:num2].to_i
  calc = Calculator.new(num1, num2)
  @calculation = calc.power.to_s
  erb :result
end

get '/' do
  erb :welcome
end

get '/about' do
  erb :about
end