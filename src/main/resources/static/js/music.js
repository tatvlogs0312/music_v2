const player = document.querySelector(".player");
const songName = document.querySelector(".song-name");
const songArtist = document.querySelector(".song-artist");
const cover = document.querySelector(".cover");
const playPauseBtn = document.querySelector(".play-pause");
const prevBtn = document.querySelector(".prev-btn");
const nextBtn = document.querySelector(".next-btn");
const audio = document.querySelector(".audio");
const srcMp3 = document.querySelector(".audio source")
const songTime = document.querySelector(".song-time");
const songProgress = document.querySelector(".song-progress");
const coverArtist = document.querySelector(".cover span:nth-child(1)");
const coverName = document.querySelector(".cover span:nth-child(2)");

// window.addEventListener("load", () =>{
//   loadSong();
// }

window.onload = function () {
  loadSong();
}

const loadSong = () => {
  // coverName.textContent = songData[index].name;
  // coverArtist.textContent = songData[index].artist;
  // songName.textContent = songData[index].name;
  // songArtist.textContent = songData[index].artist;
  audio.src = srcMp3.getAttribute('src');
};

const playSong = () => {
  player.classList.add("pause");
  cover.classList.add("rotate");
  playPauseBtn.firstElementChild.className = "fa-solid fa-pause";
  audio.play();
};

const pauseSong = () => {
  player.classList.remove("pause");
  cover.classList.remove("rotate");
  playPauseBtn.firstElementChild.className = "fa-solid fa-play";
  audio.pause();
};

playPauseBtn.addEventListener("click", () => {
  if (player.classList.contains("pause")) {
    console.log("pause");
    pauseSong();
  } else {
    console.log("play");
    playSong();
  }
});

// Giảm 5s
const prevSongPlay = () => {
  if (audio.currentTime >= 0) {
    audio.currentTime = audio.currentTime - 10;
  }
  playSong();
};

// Tăng 5s
const nextSongPlay = () => {
  audio.currentTime = audio.currentTime + 10;
  playSong();
};

prevBtn.addEventListener("click", prevSongPlay);
nextBtn.addEventListener("click", nextSongPlay);

audio.addEventListener("timeupdate", (e) => {
  // console.log(e);
  const currentTime = e.target.currentTime;
  // console.log(currentTime);
  const duration = e.target.duration;
  console.log(duration);
  let currentTimeWidth = (currentTime / duration) * 100;
  songProgress.style.width = `${currentTimeWidth}%`;

  const songCurrentTime = document.querySelector(".time span:nth-child(1)");
  const songDuration = document.querySelector(".time span:nth-child(2)");

  audio.addEventListener("loadeddata", () => {
    let audioDuration = audio.duration;
    let totalMinutes = Math.floor(audioDuration / 60);
    let totalSeconds = Math.floor(audioDuration % 60);

    if (totalSeconds < 10) {
      totalSeconds = `0${totalSeconds}`;
    }
    console.log(`${totalMinutes}:${totalSeconds}`);
    songDuration.textContent = `${totalMinutes}:${totalSeconds}`;
  });

  let currentMinutes = Math.floor(currentTime / 60);
  let currentSeconds = Math.floor(currentTime % 60);

  if (currentSeconds < 10) {
    currentSeconds = `0${currentSeconds}`;
  }

  songCurrentTime.textContent = `${currentMinutes}:${currentSeconds}`;
});

songTime.addEventListener("click", (e) => {
  console.log(e);
  let progressWidth = songTime.clientWidth;
  let clickedOffsetX = e.offsetX;
  let songDuration = audio.duration;
  console.log(clickedOffsetX);
  audio.currentTime = (clickedOffsetX / progressWidth) * songDuration;

  playSong();
});

// Lắng nghe sự kiện khi kết thúc bài hát
audio.addEventListener("ended", playSong);
