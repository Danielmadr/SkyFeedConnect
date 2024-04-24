import { defineConfig } from "vite";
import react from "@vitejs/plugin-react-swc";
import { resolve } from "path";

export default defineConfig({
  plugins: [react()],
  server: {
    port: 3000,
    open: true,
  },
  resolve: {
    alias: {
      "@components": resolve(__dirname, "src/components"),
      "@style": resolve(__dirname, "src/style"),
      "@commoncomponents": resolve(__dirname, "src/components/common"),
      "@commonstyle": resolve(__dirname, "src/style/common"),
    },
  },
  build: {
    outDir: "build",
    rollupOptions: {
      output: {
        manualChunks(id) {
          if (id.includes("node_modules")) {
            return "vendor";
          }
        },
      },
    },
  },
});
