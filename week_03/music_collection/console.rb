require_relative('models/artist.rb')
require_relative('models/album.rb')
require('pp')


artist = Artist.new({
  'name' => 'Michael Jackson'
})

artist.save
# pp Artist.all

album_1 = Album.new({
  'title' => 'Bad',
  'artist_id' => artist.id,
  'genre' => 'Pop'
})

album_2 = Album.new({
  'title' => 'Off The Wall',
  'artist_id' => artist.id,
  'genre' => 'Pop'
})

album_3 = Album.new({
  'title' => 'Thriller',
  'artist_id' => artist.id,
  'genre' => 'Pop'
})


album_1.save
album_2.save
album_3.save
# pp Album.all

pp artist.albums

pp album_2.artist