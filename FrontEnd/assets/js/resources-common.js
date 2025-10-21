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
      // don't initialize on small screens or if container not present/hidden
      if (!container || window.innerWidth < 768 || getComputedStyle(container).display === 'none') {
        // skip heavy animation on small screens / when not visible
      } else {
        const scene = new THREE.Scene();
        const camera = new THREE.PerspectiveCamera(45, 1, 0.1, 1000);
        const renderer = new THREE.WebGLRenderer({ alpha: true, antialias: true });
        const BASE_SIZE = 130;
        renderer.setPixelRatio(Math.min(window.devicePixelRatio || 1, 2));
        renderer.setSize(BASE_SIZE, BASE_SIZE);
        container.appendChild(renderer.domElement);

        const geometry = new THREE.TorusKnotGeometry(0.6, 0.15, 100, 16);
        const material = new THREE.MeshPhongMaterial({
          color: 0x3AA6A0,
          specular: 0x111111,
          shininess: 10,
          flatShading: true,
          transparent: true,
          opacity: 0.95
        });
        const torusKnot = new THREE.Mesh(geometry, material);
        scene.add(torusKnot);

        const ambientLight = new THREE.AmbientLight(0xffffff, 0.45);
        scene.add(ambientLight);
        const directionalLight = new THREE.DirectionalLight(0xffffff, 0.7);
        directionalLight.position.set(1, 1, 1);
        scene.add(directionalLight);

        camera.position.z = 2.5;

        // pause animation when tab is hidden to save CPU
        let running = true;
        document.addEventListener('visibilitychange', function () {
          running = !document.hidden;
        });

        function onResize() {
          const rect = container.getBoundingClientRect();
          const size = Math.max(80, Math.min(BASE_SIZE, rect.width, rect.height));
          renderer.setSize(size, size);
          camera.aspect = 1;
          camera.updateProjectionMatrix();
        }
        window.addEventListener('resize', onResize);
        onResize();

        function animate() {
          requestAnimationFrame(animate);
          if (!running) return;
          const t = performance.now();
          // reduced rotation speeds for gentler motion
          torusKnot.rotation.x += 0.003;
          torusKnot.rotation.y += 0.004;
          torusKnot.rotation.z += 0.001;
          // smaller floating amplitude
          torusKnot.position.y = Math.sin(t * 0.002) * 0.04;
          renderer.render(scene, camera);
        }
        animate();
      }
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
