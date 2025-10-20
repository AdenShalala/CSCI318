// Vanta.js + Three.js initialization moved to external file
(function () {
  // Initialize Vanta background
  if (window.VANTA && VANTA.GLOBE) {
    VANTA.GLOBE({
      el: "#vanta-bg",
      mouseControls: true,
      touchControls: true,
      gyroControls: false,
      minHeight: 200.00,
      minWidth: 200.00,
      scale: 1.00,
      scaleMobile: 1.00,
      color: "#3AA6A0",
      backgroundColor: "#3AA6A0",
      size: 0.80
    });
  }

  // THREE.js teal torus knot
  if (window.THREE) {
    try {
      const container = document.getElementById('teal-3d-object');
      const scene = new THREE.Scene();
      const camera = new THREE.PerspectiveCamera(75, 1, 0.1, 1000);
      const renderer = new THREE.WebGLRenderer({ alpha: true });
      renderer.setSize(150, 150);
      container.appendChild(renderer.domElement);

      const geometry = new THREE.TorusKnotGeometry(0.7, 0.2, 100, 16);
      const material = new THREE.MeshPhongMaterial({
        color: 0x3AA6A0,
        specular: 0x111111,
        shininess: 30,
        flatShading: true
      });
      const torusKnot = new THREE.Mesh(geometry, material);
      scene.add(torusKnot);

      const ambientLight = new THREE.AmbientLight(0xffffff, 0.5);
      scene.add(ambientLight);
      const directionalLight = new THREE.DirectionalLight(0xffffff, 0.8);
      directionalLight.position.set(1, 1, 1);
      scene.add(directionalLight);

      camera.position.z = 2;

      function animate() {
        requestAnimationFrame(animate);
        torusKnot.rotation.x += 0.01;
        torusKnot.rotation.y += 0.01;
        renderer.render(scene, camera);
      }
      animate();
    } catch (e) {
      console.warn('Three.js animation failed to initialize', e);
    }
  }

  // Toggle forms assigned to plus icons
  document.addEventListener('click', function (e) {
    const target = e.target.closest('[data-feather="plus"]');
    if (target) {
      const form = target.closest('.bg-white')?.querySelector('.hidden');
      if (form) form.classList.toggle('hidden');
    }
  });

  // Mobile menu toggle (safeguard if button exists)
  const mobileButton = document.getElementById('mobile-menu-button');
  if (mobileButton) {
    mobileButton.addEventListener('click', function () {
      const nav = document.querySelector('nav');
      if (nav) nav.classList.toggle('hidden');
    });
  }
})();
