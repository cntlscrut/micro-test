// Select elements
const addImageBtn = document.getElementById('add-image-btn') as HTMLButtonElement;
const animalTypeAdd = document.getElementById('animal-type-add') as HTMLSelectElement;
const imageCount = document.getElementById('image-count') as HTMLSelectElement;

const retrieveImageBtn = document.getElementById('retrieve-image-btn') as HTMLButtonElement;
const animalTypeRetrieve = document.getElementById('animal-type-retrieve') as HTMLSelectElement;
const lastImageDisplay = document.getElementById('last-image-display') as HTMLDivElement;

// Event listener for adding images
addImageBtn.addEventListener('click', async () => {
  const animalType = animalTypeAdd.value;
  const count = imageCount.value;

  try {
    const response = await fetch(`http://localhost:8080/api/animals/${animalType}/${count}`, {
      method: 'POST',
    });
    if (response.ok) {
      alert('Images added successfully');
    } else {
      alert('Failed to add images');
    }
  } catch (error) {
    console.error('Error:', error);
    alert('An error occurred');
  }
});

// Event listener for retrieving the last image
retrieveImageBtn.addEventListener('click', async () => {
  const animalType = animalTypeRetrieve.value;

  try {
    const response = await fetch(`http://localhost:8080/api/animals/${animalType}/last`);
    if (response.ok) {
      const imageBlob = await response.blob();
      const imageUrl = URL.createObjectURL(imageBlob);
      lastImageDisplay.innerHTML = `<img src="${imageUrl}" alt="Last ${animalType} image" />`;
    } else {
      alert('Failed to retrieve image');
    }
  } catch (error) {
    console.error('Error:', error);
    alert('An error occurred');
  }
});
