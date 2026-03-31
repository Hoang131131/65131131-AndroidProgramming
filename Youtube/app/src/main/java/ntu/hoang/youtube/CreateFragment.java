package ntu.hoang.youtube;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

public class CreateFragment extends Fragment {

    private PreviewView viewFinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create, container, false);
        viewFinder = view.findViewById(R.id.viewFinder);

        startCamera();

        return view;
    }

    private void startCamera() {
        ListenableFuture<ProcessCameraProvider> cameraProviderFuture =
                ProcessCameraProvider.getInstance(getContext());

        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    ProcessCameraProvider cameraProvider = cameraProviderFuture.get();

                    // Thiết lập Preview (Xem trước)
                    Preview preview = new Preview.Builder().build();
                    preview.setSurfaceProvider(viewFinder.getSurfaceProvider());

                    // Chọn Camera sau (Back Camera)
                    CameraSelector cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;

                    // Hủy các liên kết cũ và gắn Camera vào vòng đời của Fragment
                    cameraProvider.unbindAll();
                    cameraProvider.bindToLifecycle(getViewLifecycleOwner(), cameraSelector, preview);

                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, ContextCompat.getMainExecutor(getContext()));
    }
}